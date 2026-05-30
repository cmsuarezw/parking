package com.csuarez.microservices.historico_microservice.vehiculo;

import org.springframework.stereotype.Service;

@Service
public class HistoricoVehiculoMapper {

    public HistoricoVehiculoEntity toHistoricoVehiculoEntity(HistoricoVehiculoRequest request) {
        return HistoricoVehiculoEntity.builder()
                .crud(request.crud())
                .id_Cliente(request.id_Cliente())
                .matricula(request.matricula())
                .marca(request.marca())
                .modelo(request.modelo())
                .fec_Create(request.fec_Create())
                .fec_Update(request.fec_Update())
                .fec_Baja(request.fec_Baja())
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
