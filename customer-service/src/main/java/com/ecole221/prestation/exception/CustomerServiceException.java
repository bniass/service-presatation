package com.ecole221.prestation.exception;

public class CustomerServiceException extends RuntimeException{
    public CustomerServiceException(String message) {
        super(message);
    }
}
