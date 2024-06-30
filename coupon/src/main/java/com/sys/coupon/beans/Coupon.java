package com.sys.coupon.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="coupons")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    //@JsonBackReference
    @JsonIgnoreProperties(value = {"coupons", "handler","hibernateLazyInitializer"}, allowSetters = true)
    private Company company;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false, length = 25)
    private String title;

    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    private Integer amount;

    private Double price;

    private String image;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", company=" + company.getName() +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
