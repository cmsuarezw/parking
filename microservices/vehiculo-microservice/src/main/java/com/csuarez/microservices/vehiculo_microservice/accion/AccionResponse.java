package com.csuarez.microservices.vehiculo_microservice.accion;

import java.time.LocalDateTime;

public record AccionResponse(
    Integer id,
    String matricula,
    LocalDateTime fec_Entrada,
    LocalDateTime fec_Salida,
    LocalDateTime fec_Traspasado
) {

}
