package com.csuarez.microservices.cliente_microservice.cliente;

import lombok.Builder;

@Builder
public record ClienteResponse(
    String id_Cliente,
    String dni,
    String nombre,
    String apellidos,
    String email,
    String telefono,
    String ciudad,
    String fec_Create,
    String fec_Update,
    String fec_Baja,
    String fec_Traspasado
) {

}
