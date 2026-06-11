package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehiculoRequest(
    @NotNull(message="La matricula es obligatoria")
    @NotBlank(message="La matricula tiene que estar informada")
    String matricula,
    @NotNull(message="El id cliente es obligatorio")
    @NotBlank(message="El id cliente tiene que estar informado")
    String idCliente,
    @NotNull(message="La marca del vehículo es obligatoria")
    @NotBlank(message="La marca del vehículo tiene que estar informada")
    String marca,
    @NotNull(message="El modelo del vehículo es obligatorio")
    @NotBlank(message="El modelo del vehículo tiene que estar informado")
    String modelo
) {
}
