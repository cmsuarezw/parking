package com.csuarez.microservices.historico_microservice.exceptions;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.csuarez.microservices.common_exceptions.ErrorResponse;
import com.csuarez.microservices.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.csuarez.microservices.historico_microservice")
@Primary
@Slf4j
public class HistoricoExceptionHandler extends GlobalExceptionHandler{

    @ExceptionHandler(HistoricoException.class)
    public ResponseEntity<ErrorResponse> handle(HistoricoException exception) {
        var errors = new HashMap<String,String>();
        var fieldName = "Historico";
        errors.put(fieldName, exception.getMessage());

        log.warn("Historico no encontrado: %s".formatted(exception.toString()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
