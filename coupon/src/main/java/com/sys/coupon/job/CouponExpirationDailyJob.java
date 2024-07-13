package com.sys.coupon.job;

import com.sys.coupon.reposetories.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
//@Lazy
public class CouponExpirationDailyJob {
    public CouponExpirationDailyJob(){
        System.out.println(this.getClass().getSimpleName()+" was invoked");
    }
    @Autowired
    CouponRepo couponRepo;
    @Scheduled(cron = "0 0 0 * * *")
    public void deleteExpired(){
        System.out.println("DELETING EXPIRED COUPONS...");
        if(couponRepo.deleteByEndDateLessThan(Date.valueOf(LocalDate.now())) != 0)
        {
            System.out.println("EXPIRED COUPONS DELETED!!");
        }else {
            System.out.println("NO COUPONS DELETED...");
        }
    }

}
