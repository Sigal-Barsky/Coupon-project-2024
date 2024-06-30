package com.sys.coupon.controllers;

import com.sys.coupon.beans.Category;
import com.sys.coupon.beans.Company;
import com.sys.coupon.beans.Coupon;
import com.sys.coupon.exceptions.CouponSysExp;
import com.sys.coupon.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
@CrossOrigin
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestBody Coupon coupon) throws CouponSysExp {
        companyService.addCoupon(coupon);
    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CouponSysExp {
        companyService.updateCoupon(id, coupon);
    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCoupon(@PathVariable int id) throws CouponSysExp {
        companyService.deleteCoupon(id);
    }

    @PostMapping("/coupons/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Coupon> getCoupons(@PathVariable int id){
        return companyService.getCompanyCoupon(id);
    }

    @PostMapping("/byCategory/{id}/{category}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Coupon> getCouponsByCategory(@PathVariable int id, @PathVariable String category){
        return companyService.getCompanyCouponByCategory(id, Category.valueOf(category));
    }

    @PostMapping("byPrice/{id}/{maxPrice}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Coupon> getCompanyCouponByPrice(@PathVariable int id, @PathVariable double maxPrice){
        return companyService.getCompanyCouponByPrice(id, maxPrice);
    }
    @PostMapping("/details")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Company getDetails(@PathVariable int id){
        return companyService.getCompanyDetails(id);
    }

}