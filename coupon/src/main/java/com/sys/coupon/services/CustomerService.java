package com.sys.coupon.services;


import com.sys.coupon.beans.Category;
import com.sys.coupon.beans.Coupon;
import com.sys.coupon.beans.Customer;
import com.sys.coupon.exceptions.CouponSysExp;
import com.sys.coupon.exceptions.ErrMsg;
import com.sys.coupon.reposetories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService{
    private final CustomerRepo customerRepo;
    public void purchaseCoupon(Coupon coupon, Integer customerId) throws CouponSysExp {
        Customer customer = getCustomer(customerId);
        customer.getCoupons().add(coupon);
    }

    public Customer getCustomer(Integer customerId) throws CouponSysExp {
        if (customerRepo.findTopById(customerId)== null){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        return customerRepo.findTopById(customerId);
    }

    public List<Coupon> getCustomerCoupons(Integer customerId) throws CouponSysExp {
        if (customerRepo.findTopById(customerId)!= null){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        return getCustomer(customerId).getCoupons();
    }

    public List<Coupon> getCustomerCouponsByCategory(Category category) {
        return null;
    }

    public List<Coupon> getCustomerCouponsMaxPrice(Double maxPrice) {
        return null;
    }
}
