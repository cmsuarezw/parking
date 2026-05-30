package com.csuarez.microservices.cliente_microservice.exceptions;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.csuarez.microservices.common_exceptions.ErrorResponse;
import com.csuarez.microservices.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.csuarez.microservices.cliente_microservice")
@Primary
@Slf4j
public class ClienteExceptionHandler extends GlobalExceptionHandler{

    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<ErrorResponse> handle(ClienteException exception) {
        var errors = new HashMap<String,String>();
        var fieldName = "Cliente";
        errors.put(fieldName, exception.getMessage());

        log.warn("Cliente no encontrado: %s".formatted(exception.toString()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
