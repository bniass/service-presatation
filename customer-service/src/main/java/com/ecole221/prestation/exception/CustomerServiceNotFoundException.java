package com.ecole221.prestation.exception;

public class CustomerServiceNotFoundException extends RuntimeException{
    public CustomerServiceNotFoundException(String message) {
        super(message);
    }
}
