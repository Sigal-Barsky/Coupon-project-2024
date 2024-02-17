package DBDAO;

import Beans.Coupon;
import Cls.DBUtils;
import DAO.CouponDAO;
import SQL.SQLCompanyCommands;
import SQL.SQLCouponCommands;

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
    }

    public void dropCouponTable(){
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
        params.put(2,coupon.getCategoryID());
        params.put(3,coupon.getTitle());
        params.put(4,coupon.getDescription());
        params.put(5,coupon.getStart_date());
        params.put(6,coupon.getEnd_date());
        params.put(7,coupon.getAmount());
        params.put(8,coupon.getPrice());
        params.put(9,coupon.getImage());
        if (DBUtils.runQuery(SQLCouponCommands.CREATE_COUPON_TABLE, params)){
            System.out.println("Coupon added successfully");
        }
    }

    @Override
    public void updateCoupon(Coupon coupon) {

    }

    @Override
    public void deleteCoupon(Integer couponID) {

    }

    @Override
    public ArrayList<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public Coupon getOneCoupon(Integer couponID) {
        return null;
    }

    @Override
    public void addCouponPurchase(Integer customerID, Integer couponID) {

    }

    @Override
    public void deleteCouponPurchase(Integer customerID, Integer couponID) {

    }
}
