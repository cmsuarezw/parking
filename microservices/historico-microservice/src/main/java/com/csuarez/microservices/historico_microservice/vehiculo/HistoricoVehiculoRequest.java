package com.csuarez.microservices.historico_microservice.vehiculo;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoVehiculoRequest(
    @NotNull(message="El ID de matricula es obligatorio")
    @NotBlank(message="El ID de matricula tiene que estar informado")
    Number id_Matricula,
    @NotNull(message = "Crud es obligatorio")
    @NotBlank(message = "Crud no puede estar en blanco. Debe ser CREATE, UPDATE o DELETE")
    String crud,
    @NotNull(message="El ID de cliente es obligatorio")
    @NotBlank(message="El ID de cliente tiene que estar informado")
    String id_Cliente,
    @NotNull(message="La matricula es obligatorio")
    @NotBlank(message="Lamtricula tiene que estar informadd")
    String matricula,
    @NotNull(message="El marca del vehículo es obligatorio")
    @NotBlank(message="La marca del vehículo tiene que estar informada")
    String marca,
    @NotNull(message="El modelo del vehículo es obligatorio")
    @NotBlank(message="La modelo del vehículo tiene que estar informada")
    String modelo,
    @NotNull(message="La fecha de creación del vehículo es obligatoria")
    @NotBlank(message="La fecha de creación del vehículo tiene que estar informada")
    LocalDateTime fec_Create,
    LocalDateTime fec_Update,
    LocalDateTime fec_Baja
) {

}
