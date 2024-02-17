package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Customer {
    private Integer costumerID;
    private String first_name;
    private String last_name;
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

    @Override
    public String toString() {
        return "Customer: " + costumerID +
                ", name: " + first_name +
                " " + last_name +
                ", email: " + email;
    }
}
