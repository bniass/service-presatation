package com.ecole221.prestation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    public ErrorDTO handleException(Exception exception){
        return ErrorDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value()+"")
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ServicePrestationException.class})
    public ErrorDTO handleException(ServicePrestationException exception){
        return ErrorDTO.builder()
                .code(HttpStatus.FORBIDDEN.value()+"")
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, String> handleValidationsException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        });
        return errors;
    }

}
