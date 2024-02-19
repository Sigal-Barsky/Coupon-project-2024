package DAO;

import Beans.Company;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompanyDAO {
    void createCompanyTable();

    void dropCompanyTable();

    Boolean isCompanyExist(String Email, String Password) throws SQLException;
    Boolean isNameExist(String Name) throws SQLException;
    Boolean isEmailExist(String Email) throws SQLException;
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Integer companyID);
    ArrayList<Company> getAllCompanies() throws SQLException;
    Company getOneCompany(Integer companyID) throws SQLException;

    Integer getIdByEmail(String email) throws SQLException;
}
