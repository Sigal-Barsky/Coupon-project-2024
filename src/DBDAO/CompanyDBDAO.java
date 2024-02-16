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
    public Boolean isCompanyExist(String Email, String Password) {
        return null;
    }

    @Override
    public void addCompany(Company company) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        if (DBUtils.runQuery(SQLCompanyCommands.addCompany, params)){
            System.out.println("Company added successfully");
        }
    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(Integer companyID) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1, companyID);
        if (DBUtils.runQuery(SQLCompanyCommands.addCompany, params)){
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
        }
        return myList;
    }

    @Override
    public Company getOneCompany(Integer companyID) throws SQLException {
        Company company;
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);

        ResultSet results = DBUtils.runQueryFroResult(SQLCompanyCommands.getOneCompany,params);

        int id = results.getInt(1);
        String name = results.getString(2);
        String email = results.getString(3);
        String password = results.getString(4);
        ArrayList<Coupon> coupons = new ArrayList<Coupon>();;
        company = new Company(id, name, email, password, coupons);

        return company;
    }
}
