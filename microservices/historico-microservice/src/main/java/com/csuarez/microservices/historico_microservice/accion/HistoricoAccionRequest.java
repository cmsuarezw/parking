package com.csuarez.microservices.historico_microservice.accion;

import java.time.LocalDateTime;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoAccionRequest(
    @NotNull(message = "CRUD es obligatorio")
    @NotBlank(message = "CRUD no puede estar en blanco. Debe ser CREATE, UPDATE o DELETE")
    String crud,
    @NotNull(message = "El identificador de la accion es obligatorio")
    @NotBlank(message = "El identificador de la accion es obligatorio")
    Number id_Accion,
    @NotNull(message = "Matricula es obligatoria")
    @NotBlank(message = "Matricula es obligatoria")
    String matricula,
    @NotNull(message = "La fecha de entrada es obligatoria")
    @NotBlank(message = "La fecha de entrada es obligatoria")
    LocalDateTime fec_Entrada,
    LocalDateTime fec_Salida,
    @NotNull(message = "La fecha de creación de la accion es obligatoria")
    @NotBlank(message = "La fecha de creación de la accion es obligatoria")
    LocalDateTime fec_Create,
    LocalDateTime fec_Update
) {
}
