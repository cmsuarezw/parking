package com.csuarez.microservices.hist_microservice.HistCliente;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistClienteRequest(
    @NotNull(message = "CRUD no puede ser nulo")
    @NotBlank(message = "CRUD no puede estar en blanco")
    String crud,
    @NotNull(message = "idCliente no puede ser nulo")
    @NotBlank(message = "idCliente no puede estar en blanco")
    String idCliente,
    @NotNull(message = "Dni debe tener formato tipo 11111111X")
    @NotBlank(message = "Dni no puede estar en blanco")    
    String dni,
    @NotNull(message = "Nombre es obligatorio")
    @NotBlank(message = "Nombre no puede estar en blanco")
    String nombre,
    @NotNull(message = "Apellido es obligatorio")
    @NotBlank(message = "Apellido no puede estar en blanco")
    String apellidos,
    @NotNull(message = "Email es obligatorio")
    @Email(message = "Email no es valido")
    String email,
    @NotNull(message = "Teléfono es obligatorio")
    @NotBlank(message = "Teléfono no puede estar en blanco")
    String telefono,
    @NotNull(message = "Ciudad es obligatoria")
    @NotBlank(message = "Ciudad no puede estar en blanco")
    String ciudad,
    LocalDateTime fecBaja,
    LocalDateTime fecTraspasado
    
) {

}
