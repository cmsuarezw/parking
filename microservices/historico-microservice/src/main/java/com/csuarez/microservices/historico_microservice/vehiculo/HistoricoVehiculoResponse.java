package com.csuarez.microservices.historico_microservice.vehiculo;

import java.time.LocalDateTime;
import java.util.List;

import com.csuarez.microservices.historico_microservice.accion.HistoricoAccionResponse;

public record HistoricoVehiculoResponse(
    Number id,
    String crud,
    Number id_Matricula,
    String id_Cliente,
    String matricula,
    String marca,
    String modelo,
    LocalDateTime fec_Create,
    LocalDateTime fec_Update,
    LocalDateTime fec_Baja,
    List<HistoricoAccionResponse> acciones
) {

}
