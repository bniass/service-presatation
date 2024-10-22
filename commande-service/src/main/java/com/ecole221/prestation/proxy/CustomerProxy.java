package com.ecole221.prestation.proxy;

import com.ecole221.prestation.dto.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8086")
public interface CustomerProxy {
    @GetMapping("customer/find/{id}")
    public CustomerResponse findCustomer(@PathVariable String id);
}
