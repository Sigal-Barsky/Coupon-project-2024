package com.sys.coupon.reposetories;


import com.sys.coupon.beans.Category;
import com.sys.coupon.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CouponRepo extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByCompanyId(Integer companyId);

    List<Coupon> findByCompanyIdAndCategory(Integer companyId, Category category);

    List<Coupon> findByCompanyIdAndPriceLessThan(Integer companyId, Double maxPrice);

    void deleteByCompanyId(Integer companyId);
}
