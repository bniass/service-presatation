package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Customer;

public interface ICustomer {
    Customer save(Customer customer);
    Customer find(long id);
    Customer findByTel(String tel);
}
