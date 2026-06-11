package com.csuarez.microservices.historico_microservice.vehiculo;

import java.time.LocalDateTime;

public record HistoricoVehiculoResponse(
    Number id,
    String crud,
    Number idMatricula,
    String idCliente,
    String matricula,
    String marca,
    String modelo,
    LocalDateTime fecCreate,
    LocalDateTime fecUpdate,
    LocalDateTime fecBaja
) {

}
