package com.ecole221.prestation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ecole221.prestation")
public class CustomerServiceAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceAppliaction.class, args);
    }
}
