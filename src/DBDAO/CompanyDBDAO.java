package DBDAO;

import Beans.Company;
import Cls.DBUtils;
import DAO.CompanyDAO;
import SQL.SQLCompanyCommands;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompanyDBDAO implements CompanyDAO {
    @Override
    public Boolean isCompanyExist(String Email, String Password) {
        return null;
    }

    @Override
    public void addCompany(Company company) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        DBUtils.runQuery(SQLCompanyCommands.addCompany, params);
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
