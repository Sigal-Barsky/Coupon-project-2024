package DBDAO;

import Beans.Company;
import DAO.CompanyDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CompanyDBDAO implements CompanyDAO {
    @Override
    public Boolean isCompanyExist(String Email, String Password) {
        return null;
    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(Integer companyID) {

    }

    @Override
    public ArrayList<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getOneCompany(Integer companyID) {
        return null;
    }
}
