package com.sys.coupon.reposetories;


import com.sys.coupon.beans.Category;
import com.sys.coupon.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


public interface CouponRepo extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByCompanyId(Integer companyId);

    List<Coupon> findByCompanyIdAndCategory(Integer companyId, Category category);

    List<Coupon> findByCompanyIdAndPriceLessThan(Integer companyId, Double maxPrice);

    void deleteByCompanyId(Integer companyId);
    @Transactional
    @Modifying
    @Query(value = "delete from coupons where end_date <= ?",nativeQuery = true)
    int deleteByEndDateLessThan(Date date);
}
