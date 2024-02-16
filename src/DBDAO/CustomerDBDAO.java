package DBDAO;

import Beans.Customer;
import Cls.DBUtils;
import DAO.CustomerDAO;
import SQL.SQLCompanyCommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerDBDAO implements CustomerDAO {
    @Override
    public Boolean isCustomerExist(String Email, String Password) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customer.getFirst_name());
        params.put(2,customer.getLast_name());
        if (DBUtils.runQuery(SQLCompanyCommands.addCompany, params)){
            System.out.println("Company added successfully");
        }
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Integer customerID) {

    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getOneCustomer(Integer customerID) {
        return null;
    }
}
