package com.csuarez.microservices.cliente_microservice.cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public ClienteEntity toCliente(ClienteRequest request) {
        return ClienteEntity.builder()
                .id_Cliente(request.id_Cliente())
                .dni(request.dni())
                .nombre(request.nombre())
                .apellidos(request.apellidos())
                .email(request.email())
                .telefono(request.telefono())
                .ciudad(request.ciudad())
                .build();
    }

    public ClienteResponse toClienteResponse(ClienteEntity cliente) {
        return ClienteResponse.builder()
                    .id_Cliente(cliente.getId_Cliente())
                    .dni(cliente.getDni())
                    .nombre(cliente.getNombre())
                    .apellidos(cliente.getApellidos())
                    .email(cliente.getEmail())
                    .telefono(cliente.getTelefono())
                    .ciudad(cliente.getCiudad())
                    .fec_Create(cliente.getFec_Create())
                    .fec_Update(cliente.getFec_Update())
                    .fec_Baja(cliente.getFec_Baja())
                    .fec_Traspasado(cliente.getFec_Traspasado())
                    .build();
    }

}
