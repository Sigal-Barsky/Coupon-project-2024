package Beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Coupon {
    private final Integer coupon_id;
    private Integer company_id;
    private Integer category_id;
    private String title;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;
    private Integer amount;
    private Double price;
    private String image;

}
