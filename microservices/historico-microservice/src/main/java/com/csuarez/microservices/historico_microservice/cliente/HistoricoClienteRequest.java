package com.csuarez.microservices.historico_microservice.cliente;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoClienteRequest(

    @NotNull(message = "CRUD es obligatorio")
    @NotBlank(message = "CRUD no puede estar en blanco. Debe ser CREATE, UPDATE o DELETE")
    String crud,
    @NotNull(message = "ID de Cliente es obligatorio")
    @NotBlank(message = "ID de Cliente no puede estar en blanco")
    String idCliente,
    @NotNull(message = "Dni es obligatorio")
    @NotBlank(message = "Dni no puede estar en blanco")
    String dni,
    @NotNull(message = "Nombre es obligatorio")
    @NotBlank(message = "Nombre no puede estar en blanco")
    String nombre,
    @NotNull(message = "Apellidos es obligatorio")
    @NotBlank(message = "Apellidos no puede estar en blanco")
    String apellidos,
    @NotNull(message = "Email es obligatorio")
    @NotBlank(message = "Email no puede estar en blanco")
    @Email(message = "Email no es valido")
    String email,
    String telefono,
    String ciudad,
    @NotNull(message = "Fecha de creación es obligatoria")
    @NotBlank(message = "Fecha de creación no puede estar en blanco")
    LocalDateTime fecCreate,
    LocalDateTime fecUpdate,
    LocalDateTime fecBaja
) {

}
