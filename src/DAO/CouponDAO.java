package DAO;

import Beans.Company;
import Beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CouponDAO {
    void createCouponTable();
    void dropCouponTable();
    void addCoupon(Coupon coupon);
    void updateCoupon(Coupon coupon);
    void deleteCoupon(Integer couponID);

    void deleteCompanyCoupon(Integer companyID) throws SQLException;

    ArrayList<Coupon> getAllCoupons() throws SQLException;

    ArrayList<Coupon> getCompanyCoupons(Integer companyID) throws SQLException;

    Coupon getOneCoupon(Integer couponID) throws SQLException;
    void addCouponPurchase(Integer customerID, Integer couponID);
    void deleteCouponPurchase(Integer customerID, Integer couponID);

    void deleteCouponsPurchaseByID(Integer couponID);
}
