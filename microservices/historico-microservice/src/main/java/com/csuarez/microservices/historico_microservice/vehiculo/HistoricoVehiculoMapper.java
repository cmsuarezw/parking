package com.csuarez.microservices.historico_microservice.vehiculo;

import org.springframework.stereotype.Service;

@Service
public class HistoricoVehiculoMapper {

    public HistoricoVehiculoEntity toHistoricoVehiculoEntity(HistoricoVehiculoRequest request) {
        return HistoricoVehiculoEntity.builder()
                .crud(request.crud())
                .matricula(request.matricula())
                .idCliente(request.idCliente())
                .marca(request.marca())
                .modelo(request.modelo())
                .fecCreate(request.fecCreate())
                .fecUpdate(request.fecUpdate())
                .fecBaja(request.fecBaja())
                .build();
    }
/*
    public static HistoricoVehiculoResponse toHistoricoVehiculoResponse(HistoricoVehiculoEntity historicoVehiculoEntity) {
        return new HistoricoVehiculoResponse(
            historicoVehiculoEntity.getId(),
            historicoVehiculoEntity.getCrud(),
            historicoVehiculoEntity.getId_Cliente(),
            historicoVehiculoEntity.getMatricula(),
            historicoVehiculoEntity.getMarca(),
            historicoVehiculoEntity.getModelo(),
            historicoVehiculoEntity.getFec_Create(),
            historicoVehiculoEntity.getFec_Update(),
            historicoVehiculoEntity.getFec_Baja(),
            historicoVehiculoEntity.getHistoricoAccionEntity().stream()
                                   .map(HistoricoAccionMapper::toHistoricoAccionResponse)
                                   .toList()
        );
    }
*/
}
