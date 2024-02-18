package DBDAO;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Cls.DBUtils;
import DAO.CouponDAO;
import SQL.SQLCategoryCommands;
import SQL.SQLCompanyCommands;
import SQL.SQLCouponCommands;
import SQL.SQLCusvsCouCommands;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CouponDBDAO implements CouponDAO {
    @Override
    public void createCouponTable() {
        if (DBUtils.runQuery(SQLCouponCommands.CREATE_COUPON_TABLE)) {
            System.out.println("Coupon table created");
        } else {
            System.out.println("Error!");
        }
        if (DBUtils.runQuery(SQLCusvsCouCommands.CREATE_CUSTOMERS_VS_COUPONS_TABLE)) {
            System.out.println("Customers VS Coupons table created");
        } else {
            System.out.println("Error!");
        }
    }

    public void dropCouponTable(){
        if (DBUtils.runQuery(SQLCusvsCouCommands.DROP_CUSTOMERS_VS_COUPONS_TABLE)) {
            System.out.println("Customers VS Coupons table dropped");
        } else {
            System.out.println("Error!");
        }
        if (DBUtils.runQuery(SQLCouponCommands.DROP_COUPON_TABLE)) {
            System.out.println("Coupon table dropped");
        } else {
            System.out.println("Error!");
        }
    }

    @Override
    public void addCoupon(Coupon coupon) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,coupon.getCompanyID());
        params.put(2,coupon.getCategoryID().ordinal()+1);
        params.put(3,coupon.getTitle());
        params.put(4,coupon.getDescription());
        params.put(5,coupon.getStart_date());
        params.put(6,coupon.getEnd_date());
        params.put(7,coupon.getAmount());
        params.put(8,coupon.getPrice());
        params.put(9,coupon.getImage());
        if (DBUtils.runQuery(SQLCouponCommands.addCoupon, params)){
            System.out.println("Coupon added successfully");
        }
    }

    @Override
    public void updateCoupon(Coupon coupon) {

    }

    @Override
    public void deleteCoupon(Integer couponID) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1, couponID);
        if (DBUtils.runQuery(SQLCouponCommands.deleteCoupon, params)){
            System.out.println("Company deleted successfully");
        }
    }

    @Override
    public ArrayList<Coupon> getAllCoupons() throws SQLException {
        ArrayList<Coupon> myList = new ArrayList<>();

        ResultSet results = DBUtils.runQueryFroResult(SQLCouponCommands.getAllCoupons);
        while (results.next()){
            int couponId = results.getInt(1);
            int companyId = results.getInt(2);
            int categoryId = results.getInt(3);
            String title = results.getString(4);
            String description = results.getString(5);
            Date startDate = results.getDate(6);
            Date endDate = results.getDate(7);
            int amount = results.getInt(8);
            Double price = results.getDouble(9);
            String image = results.getString(10);
            myList.add(new Coupon(couponId, companyId, Category.values()[categoryId], title, description, startDate, endDate, amount, price, image));
        }
        return myList;
    }

    @Override
    public Coupon getOneCoupon(Integer couponID) throws SQLException {
        Coupon coupon = null;
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,couponID);

        ResultSet results = DBUtils.runQueryFroResult(SQLCouponCommands.getOneCoupon, params);
        while (results.next()) {
            int couponId = results.getInt(1);
            int companyId = results.getInt(2);
            int categoryId = results.getInt(3);
            String title = results.getString(4);
            String description = results.getString(5);
            Date startDate = results.getDate(6);
            Date endDate = results.getDate(7);
            int amount = results.getInt(8);
            Double price = results.getDouble(9);
            String image = results.getString(10);
            coupon = new Coupon(couponId, companyId, Category.values()[categoryId], title, description, startDate, endDate, amount, price, image);

        }
        return coupon;
    }

    @Override
    public void addCouponPurchase(Integer customerID, Integer couponID) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,couponID);
        if (DBUtils.runQuery(SQLCusvsCouCommands.addCVsC, params)){
            System.out.println("Customers VS Coupons entry added successfully");
        }
    }

    @Override
    public void deleteCouponPurchase(Integer customerID, Integer couponID) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,couponID);
        if (DBUtils.runQuery(SQLCusvsCouCommands.deleteCVsC, params)){
            System.out.println("Customers VS Coupons entry deleted successfully");
        }
    }
}
