package DBDAO;

import Beans.Company;
import Beans.Coupon;
import Cls.DBUtils;
import DAO.CompanyDAO;
import SQL.SQLCompanyCommands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CompanyDBDAO implements CompanyDAO {
    @Override
    public void createCompanyTable() {
        if (DBUtils.runQuery(SQLCompanyCommands.CREATE_COMPANY_TABLE)) {
            System.out.println("Company table created");
        } else {
            System.out.println("Error!");
        }
    }
    @Override
    public void dropCompanyTable() {
        if (DBUtils.runQuery(SQLCompanyCommands.DROP_COMPANY_TABLE)) {
            System.out.println("Company table dropped");
        } else {
            System.out.println("Error!");
        }
    }
    @Override
    public Boolean isCompanyExist(String Email, String Password) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,Email);
        params.put(2,Password);
        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.isCompanyExist, params);
        return results.getBoolean(1);
    }

    @Override
    public Boolean isNameExist(String Name) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,Name);
        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.isNameExist, params);
        return results.getBoolean(1);
    }

    @Override
    public Boolean isEmailExist(String Email) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,Email);
        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.isEmailExist, params);
        return results.getBoolean(1);
    }

    @Override
    public void addCompany(Company company) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        params.put(3,company.getPassword());
        DBUtils.runQuery(SQLCompanyCommands.addCompany, params);
    }

    @Override
    public void updateCompany(Company company) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,company.getEmail());
        params.put(2,company.getPassword());
        params.put(3,company.getCompanyID());
        DBUtils.runQuery(SQLCompanyCommands.updateCompany, params);
    }

    @Override
    public void deleteCompany(Integer companyID) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1, companyID);
        if (DBUtils.runQuery(SQLCompanyCommands.deleteCompany, params)){
            System.out.println("Company deleted successfully");
        }
    }

    @Override
    public ArrayList<Company> getAllCompanies() throws SQLException {
        ArrayList<Company> myList = new ArrayList<>();

        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.getAllCompanies);
        while (results.next()){
            int id = results.getInt(1);
            String name = results.getString(2);
            String email = results.getString(3);
            String password = results.getString(4);
            ArrayList<Coupon> coupons = new ArrayList<Coupon>();
            myList.add(new Company(id, name, email, password, coupons));
            Company.counter = id;
        }
        return myList;
    }

    @Override
    public Company getOneCompany(Integer companyID) throws SQLException {
        Company company = null;
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);

        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.getOneCompany,params);
        while (results.next()) {
            int id = results.getInt(1);
            String name = results.getString(2);
            String email = results.getString(3);
            String password = results.getString(4);
            ArrayList<Coupon> coupons = new ArrayList<Coupon>();
            company = new Company(id, name, email, password, coupons);
        }
        return company;
    }

    @Override
    public Integer getIdByEmail(String email) throws SQLException {
        Company company = null;
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,email);

        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.getIdByEmail,params);

        return results.getInt(1);
    }

}
