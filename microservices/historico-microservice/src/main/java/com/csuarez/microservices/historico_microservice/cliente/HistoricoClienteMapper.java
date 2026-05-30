package com.csuarez.microservices.historico_microservice.cliente;

import org.springframework.stereotype.Service;

@Service
public class HistoricoClienteMapper {

    public HistoricoClienteEntity toHistoricoClienteEntity(HistoricoClienteRequest request) {
        return HistoricoClienteEntity.builder()
                .crud(request.crud())
                .id_Cliente(request.id_Cliente())
                .nombre(request.nombre())
                .apellidos(request.apellidos())
                .email(request.email())
                .telefono(request.telefono())
                .ciudad(request.ciudad())
                .fec_Create(request.fec_Create())
                .fec_Update(request.fec_Update())
                .fec_Baja(request.fec_Baja())
                .build();
    }

    public HistoricoClienteResponse toHistoricoClienteResponse(HistoricoClienteEntity historicoClienteEntity) {
        return new HistoricoClienteResponse(
            historicoClienteEntity.getId(),
            historicoClienteEntity.getCrud(),
            historicoClienteEntity.getId_Cliente(),
            historicoClienteEntity.getDni(),
            historicoClienteEntity.getNombre(),
            historicoClienteEntity.getApellidos(),
            historicoClienteEntity.getEmail(),
            historicoClienteEntity.getTelefono(),
            historicoClienteEntity.getCiudad(),
            historicoClienteEntity.getFec_Create(),
            historicoClienteEntity.getFec_Update(),
            historicoClienteEntity.getFec_Baja()
        );
    }

}
