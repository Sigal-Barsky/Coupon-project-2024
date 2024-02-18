package Facade;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyFacade extends ClientFacade {
    private final Integer companyID;

    public CompanyFacade(Integer companyID) {
        this.companyID = companyID;
    }

    @Override
    public Boolean Login(String email, String password) throws SQLException {
        return companyDBDAO.isCompanyExist(email,password);
    }

    public void addCoupon(Coupon coupon) throws SQLException {
        if(!couponDBDAO.isCompanyCouponExist(coupon.getTitle(), coupon.getCompanyID())){
            couponDBDAO.addCoupon(coupon);
        }
    }

    public void updateCoupon(Coupon coupon){
        couponDBDAO.updateCoupon(coupon);
    }

    public void deleteCoupon(Integer couponID){
        couponDBDAO.deleteCouponsPurchaseByCoupon(couponID);
        couponDBDAO.deleteCoupon(couponID);
    }

    public ArrayList<Coupon> getCompanyCoupon() throws SQLException {
        return couponDBDAO.getCompanyCoupons(companyID);
    }

    public ArrayList<Coupon> getCompanyCoupon(Category category) throws SQLException {
        return couponDBDAO.getCompanyCoupons(companyID, category);
    }
    public ArrayList<Coupon> getCompanyCoupon(Double maxPrice) throws SQLException {
        return couponDBDAO.getCompanyCoupons(companyID, maxPrice);
    }

    public Company getCompanyDetails() throws SQLException {
        return companyDBDAO.getOneCompany(companyID);
    }
}
