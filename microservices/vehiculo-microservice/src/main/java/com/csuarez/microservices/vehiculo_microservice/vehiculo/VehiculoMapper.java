package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import org.springframework.stereotype.Service;

@Service
public class VehiculoMapper {

    public VehiculoEntity toVehiculo(VehiculoRequest request) {
        return VehiculoEntity.builder()
                .matricula(request.matricula())
                .id_Cliente(request.id_Cliente())
                .marca(request.marca())
                .modelo(request.modelo())
                .build();
    }

    public VehiculoEntity toVehiculoUpdate(VehiculoRequestUpdate request) {
        return VehiculoEntity.builder()
                .matricula(request.matricula())
                .marca(request.marca())
                .modelo(request.modelo())
                .build();
    }

    public VehiculoEntity toVehiculoEntity(VehiculoEntity vehiculoEntityEnity) {
        return vehiculoEntityEnity;
    }

    public VehiculoResponse toVehiculoResponse(VehiculoEntity vehiculo) {
        return new VehiculoResponse(
                    vehiculo.getId(),
                    vehiculo.getMatricula(),
                    vehiculo.getId_Cliente(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getFec_Baja(),
                    vehiculo.getFec_Traspasado()
        );
    }

}
