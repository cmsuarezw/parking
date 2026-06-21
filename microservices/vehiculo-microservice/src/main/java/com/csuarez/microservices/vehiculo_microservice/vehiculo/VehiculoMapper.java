package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import org.springframework.stereotype.Service;

@Service
public class VehiculoMapper {

    public VehiculoEntity toVehiculo(VehiculoRequest request) {
        return VehiculoEntity.builder()
                .matricula(request.matricula())
                .idCliente(request.idCliente())
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
                    vehiculo.getIdCliente(),
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getFec_Baja(),
                    vehiculo.getFec_Traspasado()
        );
    }

}
