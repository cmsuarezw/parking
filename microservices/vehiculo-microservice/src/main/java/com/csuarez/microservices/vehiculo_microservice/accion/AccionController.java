package com.csuarez.microservices.vehiculo_microservice.accion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/accion")
@RequiredArgsConstructor
public class AccionController {

    private AccionService service;

    @PostMapping("{matricula}/{accion}")
    public ResponseEntity<String> vehiculoAccion(@Valid @PathVariable("matricula") String matricula,
                                                 @Valid @PathVariable("accion") String accion){
        return ResponseEntity.ok(service.vehiculoAccion(matricula, accion));
    }

}
