package Facade;

import Beans.Company;
import Beans.Customer;
import Exeptions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class AdminFacade extends ClientFacade {

    @Override
    public Boolean Login(String email, String password) {
        return Objects.equals(email, "admin@admin.com") && Objects.equals(password, "admin");
    }
    public void AddCompany(Company company) throws SQLException {
        if (!companyDBDAO.isNameExist(company.getName()) && !companyDBDAO.isEmailExist(company.getEmail())){
            companyDBDAO.addCompany(company);
            System.out.println("company added successfully");
        }
    }

    public void updateCompany(Company company) throws SQLException, EmailAlreadyExistException {
        if (companyDBDAO.isEmailExist(company.getEmail())){
            if (Objects.equals(companyDBDAO.getOneCompany(company.getCompanyID()).getEmail(), company.getEmail())){
                companyDBDAO.updateCompany(company);
                System.out.println("Company updated successfully");
            }else throw new EmailAlreadyExistException();
        }else {
            companyDBDAO.updateCompany(company);
        }
    }

    public void deleteCompany(Integer companyID) throws SQLException {
        couponDBDAO.deleteCompanyCoupon(companyID);
        companyDBDAO.deleteCompany(companyID);
    }

    public ArrayList<Company> getAllCompany() throws SQLException {
        return companyDBDAO.getAllCompanies();
    }

    public Company getOneCompany(Integer companyID) throws SQLException {
        return companyDBDAO.getOneCompany(companyID);
    }

    public void AddCustomer(Customer customer) throws SQLException {
        if (!customerDBDAO.isEmailExist(customer.getEmail())){
            customerDBDAO.addCustomer(customer);
            System.out.println("company added successfully");
        }
    }

    public void updateCustomer(Customer customer){

    }

    public void deleteCustomer(Integer customerID){

    }

    public void getAllCustomer(){

    }

    public void getOneCustomer(Integer customerID){

    }
}
