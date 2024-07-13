package com.sys.coupon.services;


import com.sys.coupon.beans.*;
import com.sys.coupon.exceptions.*;
import com.sys.coupon.reposetories.CompanyRepo;
import com.sys.coupon.reposetories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService{
    private final CompanyRepo companyRepo;
    private final CouponRepo couponRepo;

    public void addCoupon(Coupon coupon) throws CouponSysExp {
        if (coupon.getId() != null) {
            if (couponRepo.existsById(coupon.getId())){
                System.out.println("one");
                throw new CouponSysExp(ErrMsg.ALREADY_EXISTS);
            }
        }
        couponRepo.save(coupon);
    }

    public void updateCoupon(Integer couponId, Coupon coupon) throws CouponSysExp {
        if (!couponRepo.existsById(couponId)){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        couponRepo.saveAndFlush(coupon);
    }

    public void deleteCoupon(Integer couponId) throws CouponSysExp {
        if (!couponRepo.existsById(couponId)){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        System.out.println("???");
        couponRepo.deleteById(couponId);
    }

    public List<Coupon> getCompanyCoupon(Integer companyId) {
        return couponRepo.findByCompanyId(companyId);
    }

    public List<Coupon> getCompanyCouponByCategory(Integer companyId, Category category) {
        return couponRepo.findByCompanyIdAndCategory(companyId, category);
    }

    public List<Coupon> getCompanyCouponByPrice(Integer companyId, Double maxPrice) {
        return couponRepo.findByCompanyIdAndPriceLessThan(companyId, maxPrice);
    }

    public Company getCompanyDetails(int id) {
        return companyRepo.findTopById(id);
    }

    public Company login(Credentials data){
        Company company = companyRepo.findByEmailAndPassword(data.getEmail(),data.getPassword());
        System.out.println("backend data");
        System.out.println(company);
        return company;
    }
}
