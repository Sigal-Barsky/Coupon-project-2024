package DAO;

import Beans.Company;
import Beans.Customer;

import java.util.ArrayList;

public interface CustomerDAO {
    Boolean isCustomerExist(String Email, String Password);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer customerID);
    ArrayList<Customer> getAllCustomers();
    Customer getOneCustomer(Integer customerID);
}
