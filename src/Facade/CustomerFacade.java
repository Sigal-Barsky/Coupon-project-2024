package Facade;

import Beans.Category;
import Beans.Coupon;
import Beans.Customer;
import Exeptions.WrongInfoException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFacade extends ClientFacade{
    private final Integer customerID;

    public CustomerFacade(String email, String password) throws WrongInfoException, SQLException {
        if(Login(email,password)){
            this.customerID = customerDBDAO.getIdByEmail(email);
        }else throw new WrongInfoException();
    }

    @Override
    public Boolean Login(String email, String password) throws SQLException {
        return customerDBDAO.isCustomerExist(email,password);
    }

    public void purchaseCoupon(Coupon coupon){
        couponDBDAO.addCouponPurchase(customerID, coupon.getCouponID());
    }

    public ArrayList<Coupon> getCustomerCoupons() throws SQLException {
        return couponDBDAO.getCustomerCoupons(customerID);
    }

    public ArrayList<Coupon> getCustomerCoupons(Category category) throws SQLException {
        return couponDBDAO.getCustomerCoupons(customerID, category);
    }

    public ArrayList<Coupon> getCustomerCoupons(Double maxPrice) throws SQLException {
        return couponDBDAO.getCustomerCoupons(customerID, maxPrice);
    }

    public Customer getCustomerDetails() throws SQLException {
        return customerDBDAO.getOneCustomer(customerID);
    }
}
