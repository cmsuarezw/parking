package com.csuarez.microservices.vehiculo_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class VehiculoException extends RuntimeException{

    private final String message;

}
