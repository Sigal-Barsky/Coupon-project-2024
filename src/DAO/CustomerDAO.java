package DAO;

import Beans.Company;
import Beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    void createCustomerTable();
    void dropCustomerTable();
    Boolean isCustomerExist(String Email, String Password) throws SQLException;

    Boolean isEmailExist(String Email) throws SQLException;

    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer customerID);
    ArrayList<Customer> getAllCustomers() throws SQLException;
    Customer getOneCustomer(Integer customerID) throws SQLException;

    Integer getIdByEmail(String email) throws SQLException;
}
