package com.sys.coupon.reposetories;


import com.sys.coupon.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
    boolean existsByEmail(String email);
    boolean existsByName(String name);

    Company findTopByEmail(String email);

    Company findTop1ByEmail(String email);

    Company findTopById(int id);

    Company findByEmailAndPassword(String email, String password);
}
