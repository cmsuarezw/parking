package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.time.LocalDateTime;
import java.util.List;

import com.csuarez.microservices.vehiculo_microservice.accion.AccionResponse;

public record VehiculoResponse(
    Integer id,
    String Matricula,
    String id_Cliente,
    String marca,
    String modelo,
    LocalDateTime fec_Create,
    LocalDateTime fec_Update,
    LocalDateTime fec_Baja,
    LocalDateTime fec_Traspasado,
    List<AccionResponse> acciones
) {

}
