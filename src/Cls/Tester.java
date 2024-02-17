package Cls;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import DBDAO.CustomerDBDAO;
import SQL.SQLCategoryCommands;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    private static final CompanyDBDAO companyDBDAO = new CompanyDBDAO();
    private static final CustomerDBDAO customerDBDAO = new CustomerDBDAO();
    private static final CouponDBDAO couponDBDAO = new CouponDBDAO();
    private static final Company company= new Company(Company.counter+1, "BarSiC", "LS@BarSiC.com","123123", null);
    public static void testAll(){
        testDropTable();
        testTableCreation();

        testCompany();
        testCoupon();
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


            companyDBDAO.addCompany(company);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    private static void testCoupon(){
        Date date1 = new Date(2024,2,17);
        Date date2 = new Date(2024,2,18);

        Coupon coupon = new Coupon(1, 1,Category.Grocery, "bs", "just a test", date1, date2, 30, 50.5, "none");
        couponDBDAO.addCoupon(coupon);
    }
}
