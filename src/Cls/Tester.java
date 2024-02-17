package Cls;

import Beans.Category;
import Beans.Company;
import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import DBDAO.CustomerDBDAO;
import SQL.SQLCategoryCommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    private static final CompanyDBDAO companyDBDAO = new CompanyDBDAO();
    private static final CustomerDBDAO customerDBDAO = new CustomerDBDAO();
    private static final CouponDBDAO couponDBDAO = new CouponDBDAO();
    public static void testAll(){
        testDropTable();
        testTableCreation();

        //testCompany(companyDBDAO);
        //testDropTable();
    }
    private static void testTableCreation(){
        companyDBDAO.createCompanyTable();
        customerDBDAO.createCustomerTable();
        if (DBUtils.runQuery(SQLCategoryCommands.CREATE_CATEGORY_TABLE)){
            System.out.println("category table created");
            for (int i = 0; i<4 ; i++) {
                Map<Integer,Object> params = new HashMap<>();
                params.put(1,Category.values()[i].toString());
                DBUtils.runQuery(SQLCategoryCommands.addCategory,params);
            }

        }
        couponDBDAO.createCouponTable();
    }

    private static void testDropTable(){
        couponDBDAO.dropCouponTable();
        companyDBDAO.dropCompanyTable();
        customerDBDAO.dropCustomerTable();
        if (DBUtils.runQuery(SQLCategoryCommands.DROP_CATEGORY_TABLE)){
            System.out.println("Category table dropped");
        }
    }

    private static void testCompany(){
        try {
            ArrayList<Company> companies = new ArrayList<>();
            companies = companyDBDAO.getAllCompanies();

            Company company= new Company(Company.counter+1, "BarSiC", "LS@BarSiC.com","123123", null);
            companyDBDAO.addCompany(company);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
