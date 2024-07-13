package com.sys.coupon.services;

import com.sys.coupon.beans.Company;
import com.sys.coupon.beans.Credentials;
import com.sys.coupon.beans.Customer;
import com.sys.coupon.exceptions.CouponSysExp;
import com.sys.coupon.exceptions.ErrMsg;
import com.sys.coupon.reposetories.CompanyRepo;
import com.sys.coupon.reposetories.CouponRepo;
import com.sys.coupon.reposetories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdminService{
    private final CompanyRepo companyRepo;
    private final CustomerRepo customerRepo;
    private final CouponRepo couponRepo;

    public boolean login(Credentials data){
        return (Objects.equals(data.getEmail(), "admin@coupons.com") &&
                Objects.equals(data.getPassword(), "admin"));
    }
    public void addCompany(Company company) throws CouponSysExp {
        if (company.getId() == null) {
            if (companyRepo.existsByEmail(company.getEmail())){
                throw new CouponSysExp(ErrMsg.ALREADY_EXISTS);
            }
        }
        else if (companyRepo.existsById(company.getId())){
            throw new CouponSysExp(ErrMsg.ALREADY_EXISTS);
        }
        companyRepo.save(company);
    }

    public void updateCompany(Integer companyId, Company company) throws CouponSysExp {
        if (!companyRepo.existsById(companyId)){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        companyRepo.saveAndFlush(company);
    }

    public void deleteCompany(Integer companyId) throws CouponSysExp {
        if (!companyRepo.existsById(companyId)){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        couponRepo.deleteByCompanyId(companyId);
        companyRepo.deleteById(companyId);
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company getSingleCompany(String email) throws CouponSysExp {
        if (companyRepo.findTop1ByEmail(email)== null){
            throw new CouponSysExp(ErrMsg.WRONG_INFO);
        }
        return companyRepo.findTop1ByEmail(email);
    }

    public void addCustomer(Customer customer) throws CouponSysExp {
        if (customer.getId() == null) {
            if (customerRepo.existsByEmail(customer.getEmail())){
                throw new CouponSysExp(ErrMsg.ALREADY_EXISTS);
            }
        }
        else if (customerRepo.existsById(customer.getId())){
            throw new CouponSysExp(ErrMsg.ALREADY_EXISTS);
        }
        customerRepo.save(customer);
    }

    public void updateCustomer(Integer custumerId, Customer customer) throws CouponSysExp {
        if (!customerRepo.existsById(custumerId)){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        customerRepo.saveAndFlush(customer);
    }

    public void deleteCustomer(Integer custumerId) throws CouponSysExp {
        if (!customerRepo.existsById(custumerId)){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        Customer customer = customerRepo.findTopById(custumerId);
        customer.setCoupons(null);
        customerRepo.deleteById(custumerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getSingleCustomer(String email) throws CouponSysExp {
        if (customerRepo.findTopByEmail(email)== null){
            throw new CouponSysExp(ErrMsg.ID_NOT_FOUND);
        }
        return customerRepo.findTopByEmail(email);
    }
}
