package com.ecole221.prestation.service;

import com.ecole221.prestation.model.Customer;
import com.ecole221.prestation.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerImpl implements ICustomer{
    private final CustomerRepository customerRepository;

    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer find(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findByTel(String tel) {
        return customerRepository.findByTel(tel);
    }
}
