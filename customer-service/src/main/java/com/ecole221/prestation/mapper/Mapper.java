package com.ecole221.prestation.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}