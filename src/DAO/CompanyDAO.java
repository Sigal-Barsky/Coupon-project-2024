package DAO;

import Beans.Company;

import java.util.ArrayList;

public interface CompanyDAO {
    Boolean isCompanyExist(String Email, String Password);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Integer companyID);
    ArrayList<Company> getAllCompanies();
    Company getOneCompany(Integer companyID);
}
