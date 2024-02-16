package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Customer {
    private final Integer costumerID;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private ArrayList<Coupon> coupons;

    @Override
    public String toString() {
        return "Customer: " + costumerID +
                ", name: " + first_name +
                " " + last_name +
                ", email: " + email;
    }
}
