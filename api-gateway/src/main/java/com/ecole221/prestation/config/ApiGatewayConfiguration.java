package com.ecole221.prestation.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRoter(RouteLocatorBuilder builder){
        return  builder.routes()
                .route(p -> p.path("/api/customer/**")
                        .uri("lb://customer-service"))
                .route(p -> p.path("/api/compte/**")
                        .uri("lb://compte-service"))
                .route(p -> p.path("/api/demandes/**")
                        .uri("lb://commande-service"))
                .build();
    }
}
