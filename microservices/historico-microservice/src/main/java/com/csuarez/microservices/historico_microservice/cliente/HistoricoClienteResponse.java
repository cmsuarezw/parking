package com.csuarez.microservices.historico_microservice.cliente;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record HistoricoClienteResponse(
    Number id,
    String crud,
    String idCliente,
    String dni,
    String nombre,
    String apellidos,
    String email,
    String telefono,
    String ciudad,
    LocalDateTime fecCreate,
    LocalDateTime fecUpdate,
    LocalDateTime fecBaja
) {

}
