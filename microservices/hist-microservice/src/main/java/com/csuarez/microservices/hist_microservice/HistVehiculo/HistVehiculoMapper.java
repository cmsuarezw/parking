package com.csuarez.microservices.hist_microservice.HistVehiculo;

import org.springframework.stereotype.Service;

@Service
public class HistVehiculoMapper {

    public HistVehiculoEntity toVehiculo(HistVehiculoRequest request) {
        return HistVehiculoEntity.builder()
            .crud(request.crud())
            .matricula(request.matricula())
            .idCliente(request.idCliente())
            .marca(request.marca())
            .modelo(request.modelo())
            .build();
    }
}
