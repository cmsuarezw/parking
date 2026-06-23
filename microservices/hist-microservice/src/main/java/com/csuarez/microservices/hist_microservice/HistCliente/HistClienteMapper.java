package com.csuarez.microservices.hist_microservice.HistCliente;

import org.springframework.stereotype.Service;

@Service
public class HistClienteMapper {

    public HistClienteEntity toCliente(HistClienteRequest request) {
        return HistClienteEntity.builder()
                .crud(request.crud())
                .idCliente(request.idCliente())
                .dni(request.dni())
                .nombre(request.nombre())
                .apellidos(request.apellidos())
                .email(request.email())
                .telefono(request.telefono())
                .ciudad(request.ciudad())
                .fecBaja(request.fecBaja())
                .fecTraspasado(request.fecTraspasado())
                .build();
    }
}
