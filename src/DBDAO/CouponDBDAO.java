package DBDAO;

import Beans.Coupon;
import DAO.CouponDAO;

import java.util.ArrayList;

public class CouponDBDAO implements CouponDAO {
    @Override
    public void addCoupon(Coupon coupon) {

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
