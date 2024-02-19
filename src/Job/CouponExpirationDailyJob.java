package Job;

import DBDAO.CouponDBDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class CouponExpirationDailyJob implements Runnable{
    private CouponDBDAO couponDBDAO;
    private Boolean quit = false;

    private final int TIME = 1000*60*60*24;
    @Override
    public void run() {
        while (!quit){
            Date date = new Date(System.currentTimeMillis());
            try {
                for (Integer integer:  couponDBDAO.getExpiredCoupons(date)){
                    couponDBDAO.deleteCoupon(integer);
                }
                Thread.sleep(TIME);
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        quit = true;
    }
}
