package DAO;

import Beans.Company;
import Beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    Boolean isCustomerExist(String Email, String Password) throws SQLException;
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer customerID);
    ArrayList<Customer> getAllCustomers() throws SQLException;
    Customer getOneCustomer(Integer customerID) throws SQLException;
}
