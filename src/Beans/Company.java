package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Company {
    private final Integer companyID;
    private String name;
    private String email;
    private String password;
    private ArrayList<Coupon> coupons;
}
