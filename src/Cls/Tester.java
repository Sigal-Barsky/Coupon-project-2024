package Cls;

import Beans.*;
import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import DBDAO.CustomerDBDAO;
import Exeptions.AlreadyExistException;
import Exeptions.EmailAlreadyExistException;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Job.CouponExpirationDailyJob;
import SQL.SQLCategoryCommands;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Tester {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CompanyDBDAO companyDBDAO = new CompanyDBDAO();
    private static final CustomerDBDAO customerDBDAO = new CustomerDBDAO();
    private static final CouponDBDAO couponDBDAO = new CouponDBDAO();

    private static ArrayList<Company> companies = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Coupon> coupons = new ArrayList<>();
    private static final LoginManager loginManager = LoginManager.getInstance();

    public static void testAll() {
        testDropTable();
        testTableCreation();
        innitLists();
        try {

            testTableCreation();
            CouponExpirationDailyJob job = new CouponExpirationDailyJob();
            Thread thread = new Thread(job);
            thread.start();
            testAdmin();
            System.out.println("------------------------------");
            testCompany();
            thread.interrupt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void innitLists(){
        companies.add(new Company(Company.counter + 1, "BarSiC", "LS@BarSiC.com", "123123", null));
        companies.add(new Company(Company.counter + 1, "dummy company1", "d1@dummy.com", "123123", null));
        companies.add(new Company(Company.counter + 1, "dummy company2", "d2@dummy.com", "123123", null));
        companies.add(new Company(Company.counter + 1, "dummy company3", "d3@dummy.com", "123123", null));
        customers.add(new Customer(Customer.counter + 1, "Mila", "Barsky", "SS@gmail.com", "123123", null));
        customers.add(new Customer(Customer.counter + 1, "Dummy1", "customer", "dummy1@gmail.com", "123123", null));
        customers.add(new Customer(Customer.counter + 1, "Dummy2", "customer", "dummy2@gmail.com", "123123", null));
        Date date1 = Date.valueOf(LocalDate.now());
        Date date2 = Date.valueOf(LocalDate.now().plusDays(1));
        coupons.add(new Coupon(1, 1, Category.Grocery, "test1", "none", date1, date2, 10, 50.5, "none"));
        coupons.add(new Coupon(2, 1, Category.Restaurant, "test2", "none", date1, date2, 10, 50.5, "none"));
        coupons.add(new Coupon(3, 1, Category.Grocery, "test3", "none", date1, date2, 10, 50.5, "none"));
    }

    private static void testCompany() throws SQLException {
        System.out.println("now logging into the Company account BarSiC:");
        //LoginManager loginManager = LoginManager.getInstance();
        CompanyFacade company = (CompanyFacade) loginManager.login(companies.get(0).getEmail(), companies.get(0).getPassword(), ClientType.Company);
        if (company != null) {
            System.out.println("login successful!");

            System.out.println("add coupons to company? y/n");
            String input = scanner.nextLine();
            if (Objects.equals(input, "y")) {
                try {
                    company.addCoupon(coupons.get(0));
                    company.addCoupon(coupons.get(1));
                    company.addCoupon(coupons.get(2));
                    coupons = company.getCompanyCoupon();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("update company coupon? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")) {
                System.out.println(" change coupon 1 name to 'fancy' and description to 'good'");
                coupons.get(0).setTitle("fancy");
                coupons.get(0).setDescription("good");
                company.updateCoupon(coupons.get(0));
                System.out.println(coupons.get(0).toString());

            }

            System.out.println("delete company coupon? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")) {
                System.out.println("deleting company: " + coupons.get(1).getTitle());
                company.deleteCoupon(coupons.get(1).getCouponID());
            }

            System.out.println("get all coupons from company? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")) {
                coupons = company.getCompanyCoupon();
                System.out.println(coupons.toString());

            }

            System.out.println("get company details? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")) {
                Company companyDits = company.getCompanyDetails();
                System.out.println(companyDits);
            }
            }
        }

    private static void testAdmin() throws SQLException {
        System.out.println("now logging into the Admin account:");

        AdminFacade admin = (AdminFacade) loginManager.login("admin@admin.com", "admin", ClientType.Administrator);
        if (admin != null) {
            System.out.println("login successful!");

            System.out.println("add company? y/n");
            String input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                try {
                    admin.AddCompany(companies.get(0));
                    admin.AddCompany(companies.get(1));
                    admin.AddCompany(companies.get(2));
                    admin.AddCompany(companies.get(3));
                    companies = companyDBDAO.getAllCompanies();
                    System.out.println(companies.toString());
                } catch (AlreadyExistException e) {
                    System.out.println("company already exists");
                }
            }

            System.out.println("update company? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                try {
                    System.out.println("changing Email to BS@gmail.com and password to 123456");
                    companies.get(0).setEmail("BS@gmail.com");
                    System.out.println("1");
                    companies.get(0).setPassword("123456");
                    System.out.println("2");
                    admin.updateCompany(companies.get(0));
                    System.out.println("3");
                } catch (EmailAlreadyExistException e) {
                    System.out.println("this new email already exists in another company");
                }
            }

            System.out.println("delete company? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                System.out.println("deleting company: " + companies.get(1).getName());
                admin.deleteCompany(companies.get(1).getCompanyID());
            }

            System.out.println("get all companies? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                companies = admin.getAllCompany();
                System.out.println(companies.toString());

            }

            System.out.println("get BarSiC company? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                Company company = admin.getOneCompany(1);
                System.out.println(company.toString());
            }

            //----------------------------------------------------------------

            System.out.println("add customer? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                try {
                    admin.AddCustomer(customers.get(0));
                    admin.AddCustomer(customers.get(1));
                    admin.AddCustomer(customers.get(2));
                    customers = customerDBDAO.getAllCustomers();
                } catch (AlreadyExistException e) {
                    System.out.println("company already exists");
                }
            }

            System.out.println("update customer? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                try {
                    System.out.println("changing Email to BS@gmail.com and password to 123456");
                    customers.get(0).setEmail("BS@gmail.com");
                    customers.get(0).setPassword("123456");
                    admin.updateCustomer(customers.get(0));
                } catch (EmailAlreadyExistException e) {
                    System.out.println("this new email already used by another user");
                }
            }

            System.out.println("delete customer? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                System.out.println("deleting customer: "
                        + customers.get(1).getFirst_name() + customers.get(1).getLast_name());
                admin.deleteCustomer(customers.get(1).getCostumerID());
            }

            System.out.println("get all customers? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                customers = admin.getAllCustomer();
                System.out.println(customers.toString());

            }

            System.out.println("get BarSiC company? y/n");
            input = scanner.nextLine();
            if (Objects.equals(input, "y")){
                Customer customer = admin.getOneCustomer(1);
                System.out.println(customer.toString());
            }

        }
    }

    private static void testTableCreation() {
        companyDBDAO.createCompanyTable();
        customerDBDAO.createCustomerTable();
        if (DBUtils.runQuery(SQLCategoryCommands.CREATE_CATEGORY_TABLE)) {
            System.out.println("category table created");
            for (int i = 0; i < 4; i++) {
                Map<Integer, Object> params = new HashMap<>();
                params.put(1, Category.values()[i].toString());
                DBUtils.runQuery(SQLCategoryCommands.addCategory, params);
            }

        }
        couponDBDAO.createCouponTable();
    }

    private static void testDropTable() {
        couponDBDAO.dropCouponTable();
        companyDBDAO.dropCompanyTable();
        customerDBDAO.dropCustomerTable();
        if (DBUtils.runQuery(SQLCategoryCommands.DROP_CATEGORY_TABLE)) {
            System.out.println("Category table dropped");
        }
    }
}
