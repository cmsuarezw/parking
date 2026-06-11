package com.csuarez.microservices.historico_microservice.cliente;

import org.springframework.stereotype.Service;

@Service
public class HistoricoClienteMapper {

    public HistoricoClienteEntity toHistoricoClienteEntity(HistoricoClienteRequest request) {
        return HistoricoClienteEntity.builder()
                .crud(request.crud())
                .idCliente(request.idCliente())
                .nombre(request.nombre())
                .apellidos(request.apellidos())
                .email(request.email())
                .telefono(request.telefono())
                .ciudad(request.ciudad())
                .fecCreate(request.fecCreate())
                .fecUpdate(request.fecUpdate())
                .fecBaja(request.fecBaja())
                .build();
    }

    public HistoricoClienteResponse toHistoricoClienteResponse(HistoricoClienteEntity historicoClienteEntity) {
        return new HistoricoClienteResponse(
            historicoClienteEntity.getId(),
            historicoClienteEntity.getCrud(),
            historicoClienteEntity.getIdCliente(),
            historicoClienteEntity.getDni(),
            historicoClienteEntity.getNombre(),
            historicoClienteEntity.getApellidos(),
            historicoClienteEntity.getEmail(),
            historicoClienteEntity.getTelefono(),
            historicoClienteEntity.getCiudad(),
            historicoClienteEntity.getFecCreate(),
            historicoClienteEntity.getFecUpdate(),
            historicoClienteEntity.getFecBaja()
        );
    }

}
