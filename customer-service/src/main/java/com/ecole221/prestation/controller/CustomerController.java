package com.ecole221.prestation.controller;

import com.ecole221.prestation.dto.CustomerResponse;
import com.ecole221.prestation.helper.CustomerHelper;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerHelper customerHelper;

    public CustomerController(CustomerHelper customerHelper) {
        this.customerHelper = customerHelper;
    }

    @GetMapping("/{tel}")
    public CustomerResponse getCustomer(@PathVariable String tel){
        return customerHelper.getCustomer(tel);
    }

    @GetMapping("/find/{id}")
    public CustomerResponse getCustomerById(@PathVariable String id){
        return customerHelper.getCustomerById(id);
    }
}
