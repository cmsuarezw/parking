package com.csuarez.microservices.vehiculo_microservice.accion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccionRequest(
    @NotNull(message="La matricula es obligatoria")
    @NotBlank(message="La matricula tiene que estar informada")
    String matricula,
    @NotNull(message="La accion es obligatoria y deber ser ENTRADA o SALIDA")
    @NotBlank(message="La accion tiene que estar informada y ser ENTRADA o SALIDA")
    

) {

}
