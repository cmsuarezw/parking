package com.csuarez.microservices.vehiculo_microservice.Cliente;

public record ClienteResponse(
    String id_Cliente,
    String dni,
    String nombre,
    String apellidos,
    String email,
    String telefono,
    String ciudad,
    String baja,
    String fecBaja,
    String fecCreate,
    String fecUpdate,
    String traspasado    
) {

}
