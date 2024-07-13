package com.sys.coupon.reposetories;


import com.sys.coupon.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    Customer findTopById(Integer custumerId);

    Customer findTopByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);
}
