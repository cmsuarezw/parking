package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehiculoRequestUpdate(
    @NotNull(message="La mtaricula del vehículo es obligatorio")
    @NotBlank(message="El matricula de vehículo tiene que estar informado")
    String matricula,
    @NotNull(message="La marca del vehículo es obligatoria")
    @NotBlank(message="La marca del vehículo tiene que estar informada")
    String marca,
    @NotNull(message="El modelo del vehículo es obligatorio")
    @NotBlank(message="El modelo del vehículo tiene que estar informado")
    String modelo
) {
}
