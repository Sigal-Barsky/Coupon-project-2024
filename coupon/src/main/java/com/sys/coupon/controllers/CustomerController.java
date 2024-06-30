package com.sys.coupon.controllers;

import com.sys.coupon.beans.Category;
import com.sys.coupon.beans.Coupon;
import com.sys.coupon.beans.Customer;
import com.sys.coupon.exceptions.CouponSysExp;
import com.sys.coupon.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController extends ClientController{
    private final CustomerService customerService;
    @PostMapping("/details")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getDetails(@PathVariable int id) throws CouponSysExp {
        return customerService.getCustomer(id);
    }
    @PostMapping("/coupons/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Coupon> getCoupons(@PathVariable int id) throws CouponSysExp {
        return customerService.getCustomerCoupons(id);
    }
    @PostMapping("/byCategory/{category}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Coupon> getCouponsByCategory(@PathVariable String category){
        return customerService.getCustomerCouponsByCategory(Category.valueOf(category));
    }

    @PostMapping("byPrice/{maxPrice}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Coupon> getCouponByPrice(@PathVariable double maxPrice){
        return customerService.getCustomerCouponsMaxPrice(maxPrice);
    }

}
