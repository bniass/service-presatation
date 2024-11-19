package com.ecole221.prestation.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayDebugConfig {
    @Bean
    public GlobalFilter logRequestFilter() {
        return (exchange, chain) -> {
            //System.out.println("Headers : " + exchange.getRequest().getHeaders());
            return chain.filter(exchange);
        };
    }
}
