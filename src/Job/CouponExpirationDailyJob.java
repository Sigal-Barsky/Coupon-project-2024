package Job;

import DBDAO.CouponDBDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class CouponExpirationDailyJob implements Runnable{
    private final CouponDBDAO couponDBDAO = new CouponDBDAO();
    private volatile Boolean quit = false;
    private final int TIME = 1000*60*60*24;

    public CouponExpirationDailyJob() {
    }

    @Override
    public void run() {
        while (!quit){
            Date date = new Date(System.currentTimeMillis());
            try {
                for (Integer integer:  couponDBDAO.getExpiredCoupons(date)){
                    couponDBDAO.deleteCoupon(integer);
                }
                System.out.println("all expired coupons deleted");
                Thread.sleep(TIME);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }catch (InterruptedException e){
                stop();
            }
        }
    }

    public void stop() {
        System.out.println("coupon expiration checking stopped");
        quit = true;
    }
}
