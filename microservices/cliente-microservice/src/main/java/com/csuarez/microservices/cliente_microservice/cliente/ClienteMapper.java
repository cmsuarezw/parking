package com.csuarez.microservices.cliente_microservice.cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public ClienteEntity toCliente(ClienteRequest request) {
        return ClienteEntity.builder()
                .idCliente(request.idCliente())
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
                    .idCliente(cliente.getIdCliente())
                    .dni(cliente.getDni())
                    .nombre(cliente.getNombre())
                    .apellidos(cliente.getApellidos())
                    .email(cliente.getEmail())
                    .telefono(cliente.getTelefono())
                    .ciudad(cliente.getCiudad())
                    .fec_Baja(cliente.getFecBaja())
                    .fec_Traspasado(cliente.getFecTraspasado())
                    .build();
    }

}
