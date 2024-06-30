package com.sys.coupon.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String first_name;

    @Column(nullable = false, length = 25)
    private String last_name;

    @Column(nullable = false, unique = true, length = 25)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Singular
    private List<Coupon> coupons = new ArrayList<>();

//    @Override
//    public String toString(){
//        String string = "Name: " + this.getFirst_name() + " " + getLast_name() + ", Email: " + this.email;
//        return string;
//    }
}
