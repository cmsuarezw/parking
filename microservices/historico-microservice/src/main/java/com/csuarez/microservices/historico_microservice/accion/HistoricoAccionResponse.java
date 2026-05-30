package com.csuarez.microservices.historico_microservice.accion;

import java.time.LocalDateTime;

public record HistoricoAccionResponse(
    Number id,
    String crud,
    Number id_Accion,
    String matricula,
    LocalDateTime fec_Entrada,
    LocalDateTime fec_Salida,
    LocalDateTime fec_Create,
    LocalDateTime fec_Update
) {

}
