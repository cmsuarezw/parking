package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.time.LocalDateTime;

public record VehiculoResponse(
    Integer id,
    String Matricula,
    String idCliente,
    String marca,
    String modelo,
    LocalDateTime fec_Baja,
    LocalDateTime fec_Traspasado
) {

}
