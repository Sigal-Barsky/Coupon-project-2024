package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Company {
    private Integer companyID;
    private String name;
    private String email;
    private String password;
    private ArrayList<Coupon> coupons;
    public static Integer counter = 0;
    public void addToCoupons(Coupon coupon){
        if (this.coupons == null){
            this.coupons = new ArrayList<>();
        }
        this.coupons.add(coupon);
    }
}
