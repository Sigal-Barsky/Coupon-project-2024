package DAO;

import Beans.Company;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompanyDAO {
    Boolean isCompanyExist(String Email, String Password) throws SQLException;
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Integer companyID);
    ArrayList<Company> getAllCompanies() throws SQLException;
    Company getOneCompany(Integer companyID) throws SQLException;
}
