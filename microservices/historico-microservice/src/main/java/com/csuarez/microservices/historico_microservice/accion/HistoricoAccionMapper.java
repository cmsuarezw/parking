package com.csuarez.microservices.historico_microservice.accion;

import org.springframework.stereotype.Service;

@Service
public class HistoricoAccionMapper {

    public HistoricoAccionEntity toHistoricoAccionEntity(HistoricoAccionRequest request) {
        return HistoricoAccionEntity.builder()
            .crud(request.crud())
            .id_Accion(request.id_Accion())
            .matricula(request.matricula())
            .fec_Entrada(request.fec_Entrada())
            .fec_Entrada(request.fec_Entrada())
            .fec_Create(request.fec_Create())
            .fec_Update(request.fec_Update())
        .build();
    }
    public static HistoricoAccionResponse toHistoricoAccionResponse(HistoricoAccionEntity historicoAccionEntity) {
        return new HistoricoAccionResponse(
            historicoAccionEntity.getId(),
            historicoAccionEntity.getCrud(),
            historicoAccionEntity.getId_Accion(),
            historicoAccionEntity.getMatricula(),
            historicoAccionEntity.getFec_Entrada(),
            historicoAccionEntity.getFec_Salida(),
            historicoAccionEntity.getFec_Create(),
            historicoAccionEntity.getFec_Update()
            
        );
    }
}
