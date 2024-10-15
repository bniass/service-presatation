package com.ecole221.prestation.repository;

import com.ecole221.prestation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByTel(String tel);
}
