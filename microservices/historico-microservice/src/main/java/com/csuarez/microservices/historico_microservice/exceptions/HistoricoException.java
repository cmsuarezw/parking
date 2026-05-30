package com.csuarez.microservices.historico_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HistoricoException extends RuntimeException{

    private final String message;
}
