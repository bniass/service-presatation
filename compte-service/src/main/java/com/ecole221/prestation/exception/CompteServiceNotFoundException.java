package com.ecole221.prestation.exception;

public class CompteServiceNotFoundException extends RuntimeException{
    public CompteServiceNotFoundException(String message) {
        super(message);
    }
}
