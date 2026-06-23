package com.csuarez.microservices.hist_microservice.HistVehiculo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/histVehiculo")
@RequiredArgsConstructor
@Slf4j
public class HistVehiculoController {

    private final HistVehiculoService service;

    @PostMapping
    public ResponseEntity<String> createVehiculo(@Valid @RequestBody HistVehiculoRequest request) {
        return ResponseEntity.ok(service.createVehiculo(request));
    }
}
