package DBDAO;

import Beans.Coupon;
import Beans.Customer;
import Cls.DBUtils;
import DAO.CustomerDAO;
import SQL.SQLCompanyCommands;
import SQL.SQLCustomerCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDBDAO implements CustomerDAO {
    @Override
    public void createCustomerTable() {
        if (DBUtils.runQuery(SQLCustomerCommands.CREATE_CUSTOMER_TABLE)) {
            System.out.println("Customer table created");
        } else {
            System.out.println("Error!");
        }
    }
    public void dropCustomerTable() {
        if (DBUtils.runQuery(SQLCustomerCommands.DROP_CUSTOMER_TABLE)) {
            System.out.println("Customer table dropped");
        } else {
            System.out.println("Error!");
        }
    }

    @Override
    public Boolean isCustomerExist(String Email, String Password) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,Email);
        params.put(2,Password);
        ResultSet results = DBUtils.runQueryFroResult(SQLCustomerCommands.isCustomerExist, params);
        return results.getBoolean(1);
    }

    @Override
    public Boolean isEmailExist(String Email) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,Email);
        ResultSet results = DBUtils.runQueryFroResult(SQLCustomerCommands.isEmailExist, params);
        return results.getBoolean(1);
    }

    @Override
    public void addCustomer(Customer customer) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customer.getFirst_name());
        params.put(2,customer.getLast_name());
        params.put(3,customer.getEmail());
        params.put(4,customer.getPassword());
        if (DBUtils.runQuery(SQLCustomerCommands.addCustomer, params)){
            System.out.println("Customer added successfully");
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customer.getFirst_name());
        params.put(2,customer.getLast_name());
        params.put(3,customer.getEmail());
        params.put(4,customer.getPassword());
        params.put(5,customer.getCostumerID());
        DBUtils.runQuery(SQLCompanyCommands.updateCompany, params);
    }

    @Override
    public void deleteCustomer(Integer customerID) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1, customerID);
        if (DBUtils.runQuery(SQLCustomerCommands.deleteCustomer, params)){
            System.out.println("Customer deleted successfully");
        }
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException {
        ArrayList<Customer> myList = new ArrayList<>();

        ResultSet results = DBUtils.runQueryFroResult(SQLCustomerCommands.getAllCustomers);
        while (results.next()){
            int id = results.getInt(1);
            String firstname = results.getString(2);
            String lastname = results.getString(3);
            String email = results.getString(4);
            String password = results.getString(5);
            ArrayList<Coupon> coupons = new ArrayList<Coupon>();
            myList.add(new Customer(id, firstname, lastname, email, password, coupons));
        }
        return myList;
    }

    @Override
    public Customer getOneCustomer(Integer customerID) throws SQLException {
        Customer customer;
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);

        ResultSet results = DBUtils.runQueryFroResult(SQLCustomerCommands.getOneCustomer,params);

        int id = results.getInt(1);
        String firstname = results.getString(2);
        String lastname = results.getString(3);
        String email = results.getString(4);
        String password = results.getString(5);
        ArrayList<Coupon> coupons = new ArrayList<Coupon>();;
        customer = new Customer(id, firstname, lastname, email, password, coupons);

        return customer;
    }
}
