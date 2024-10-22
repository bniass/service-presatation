package com.ecole221.prestation.helper;

import com.ecole221.prestation.exception.CustomerServiceNotFoundException;
import com.ecole221.prestation.mapper.Mapper;
import com.ecole221.prestation.model.Customer;
import com.ecole221.prestation.service.ICustomer;
import com.ecole221.prestation.dto.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerHelper {
    private final ICustomer iCustomer;
    private final Mapper mapper;

    public CustomerHelper(ICustomer iCustomer, Mapper mapper) {
        this.iCustomer = iCustomer;
        this.mapper = mapper;
    }

    public CustomerResponse getCustomer(String tel){
        Customer customer = iCustomer.findByTel(tel);
        if(customer == null){
            throw new CustomerServiceNotFoundException("pas de customer avec le tel:"+tel);
        }
        return  mapper.modelMapper().map(customer, CustomerResponse.class);
    }
    public CustomerResponse getCustomerById(String id){
        Customer customer = iCustomer.find(Long.parseLong(id));
        if(customer == null){
            throw new CustomerServiceNotFoundException("Customer avec id "+id+" introuvable!");
        }
        return  mapper.modelMapper().map(customer, CustomerResponse.class);
    }
}
