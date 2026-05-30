package com.csuarez.microservices.vehiculo_microservice.exceptions;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.csuarez.microservices.common_exceptions.ErrorResponse;
import com.csuarez.microservices.common_exceptions.GlobalExceptionHandler;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.csuarez.microservices.vehiculo_microservice")
@Primary
@Slf4j
public class VehiculoExceptionHandler extends GlobalExceptionHandler{

    @ExceptionHandler(VehiculoException.class)
    public ResponseEntity<ErrorResponse> handle(VehiculoException exception) {
        var errors = new HashMap<String,String>();
        var fieldName = "Vehiculo";
        errors.put(fieldName, exception.getMessage());

        log.warn("Vehiculo no encontrado: %s".formatted(exception.toString()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException exception) {
        var errors = new HashMap<String, String>();
        var fieldName = "Error de comunicación con el microservicio";

        errors.put(fieldName, exception.getMessage());
        
        log.warn("Error communicating with microservice: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 
    }

}
