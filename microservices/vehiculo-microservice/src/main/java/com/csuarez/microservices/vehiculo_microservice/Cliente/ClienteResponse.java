package com.csuarez.microservices.vehiculo_microservice.Cliente;

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
