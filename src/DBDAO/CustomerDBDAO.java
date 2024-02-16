package DBDAO;

import Beans.Customer;
import DAO.CustomerDAO;

import java.util.ArrayList;

public class CustomerDBDAO implements CustomerDAO {
    @Override
    public Boolean isCustomerExist(String Email, String Password) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

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
