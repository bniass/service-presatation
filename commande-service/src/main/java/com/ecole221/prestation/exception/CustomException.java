package com.ecole221.prestation.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomException extends RuntimeException{
    private List<String> errors;
    public CustomException(List<String> errors) {
        this.errors = errors;
    }

}
