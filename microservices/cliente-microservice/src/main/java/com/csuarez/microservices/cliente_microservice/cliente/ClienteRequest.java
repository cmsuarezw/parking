package com.csuarez.microservices.cliente_microservice.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
    String idCliente,
// Para testing inicial, se utilizará un calculador de DNI
    //@NotNull(message = "Dni debe tener formato tipo 11111111X")
    //@NotBlank(message = "Dni no puede estar en blanco")    
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
    String ciudad
) {

}
