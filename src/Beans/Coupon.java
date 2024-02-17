package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Coupon {
    private Integer couponID;
    private Integer companyID;
    private Category categoryID;
    private String title;
    private String description;
    private Date start_date;
    private Date end_date;
    private Integer amount;
    private Double price;
    private String image;

}
