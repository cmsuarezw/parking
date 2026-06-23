package com.csuarez.microservices.hist_microservice.HistVehiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistVehiculoRequest(
    @NotNull(message = "CRUD no puede ser nulo")
    @NotBlank(message = "CRUD no puede estar en blanco")
    String crud,
    @NotNull(message="El idVehiculo obligatorio")
    @NotBlank(message="El idVehiculo tiene que estar informado")
    int idVehiculo,
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
