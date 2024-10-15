package com.ecole221.prestation.mapper;

import com.ecole221.prestation.kafka.avro.model.CustomerCreateRequestAvroModel;
import com.ecole221.prestation.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer customerCreateRequestAvromModelToCustomer(CustomerCreateRequestAvroModel customerCreateRequestAvroModel){
        return  Customer.builder()
                .id(0)
                .tel(customerCreateRequestAvroModel.getTel())
                .nom(customerCreateRequestAvroModel.getNom())
                .prenom(customerCreateRequestAvroModel.getPrenom())
                .dateNaissance(customerCreateRequestAvroModel.getDateNaissance())
                .build();
    }
}
