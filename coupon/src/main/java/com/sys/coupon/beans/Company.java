package com.sys.coupon.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="companies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 25)
    private String name;

    @Column(nullable = false, unique = true, length = 25)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    private List<Coupon> coupons;

//    @Override
//    public String toString(){
//        String string = "Name: " + this.getName() + ", Email: " + this.email;
//        return string;
//    }
}
