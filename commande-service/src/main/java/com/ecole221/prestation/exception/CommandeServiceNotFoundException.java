package com.ecole221.prestation.exception;

public class CommandeServiceNotFoundException extends RuntimeException{
    public CommandeServiceNotFoundException(String message) {
        super(message);
    }
}
