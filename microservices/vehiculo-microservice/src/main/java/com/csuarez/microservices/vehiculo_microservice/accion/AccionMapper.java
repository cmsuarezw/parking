package com.csuarez.microservices.vehiculo_microservice.accion;

import org.springframework.stereotype.Service;

@Service
public class AccionMapper {

    public AccionEntity toAccionVehiculo(AccionRequest request) {
        return AccionEntity.builder()
                .matricula(request.matricula())
                .fec_Entrada(null)
                .fec_Salida(null)
                .build();
    }

    public static AccionResponse toAccionResponse(AccionEntity accion) {
        return new AccionResponse(
            accion.getId(),
            accion.getMatricula(),
            accion.getFec_Entrada(),
            accion.getFec_Salida(),
            accion.getFec_Traspasado()
        );
    }

}
