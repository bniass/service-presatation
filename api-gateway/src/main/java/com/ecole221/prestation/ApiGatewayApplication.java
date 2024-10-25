package com.ecole221.prestation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication{
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);

    }


}