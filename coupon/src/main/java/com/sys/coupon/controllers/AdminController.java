package com.sys.coupon.controllers;

import com.sys.coupon.beans.Company;
import com.sys.coupon.beans.Customer;
import com.sys.coupon.exceptions.CouponSysExp;
import com.sys.coupon.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@CrossOrigin
public class AdminController extends ClientController{
    private final AdminService adminService;

    @PostMapping("/addCom")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestBody Company company) throws CouponSysExp {
        adminService.addCompany(company);
    }

    @PostMapping("/updateCom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable int id, @RequestBody Company company) throws CouponSysExp {
        adminService.updateCompany(id,company);
    }

    @PostMapping("/deleteCom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CouponSysExp {
        adminService.deleteCompany(id);
    }

    @GetMapping("/listCom")
    public List<Company> getAllCompanies(){
        return adminService.getAllCompanies();
    }
    @GetMapping("/singleCom/{email}")
    public Company getSingleCompany(@PathVariable String email) throws CouponSysExp {
        return adminService.getSingleCompany(email);
    }
    @PostMapping("/addCus")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) throws CouponSysExp {
        adminService.addCustomer(customer);
    }

    @PostMapping("/updateCus/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCus(@PathVariable int id, @RequestBody Customer customer) throws CouponSysExp {
        adminService.updateCustomer(id,customer);
    }

    @PostMapping("/deleteCus/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws CouponSysExp {
        adminService.deleteCustomer(id);
    }
    @GetMapping("/listCus")
    public List<Customer> getAllCustomers(){
        return adminService.getAllCustomers();
    }
    @GetMapping("/singleCus/{email}")
    public Customer getSingleCustomer(@PathVariable String email) throws CouponSysExp {
        return adminService.getSingleCustomer(email);
    }
}
