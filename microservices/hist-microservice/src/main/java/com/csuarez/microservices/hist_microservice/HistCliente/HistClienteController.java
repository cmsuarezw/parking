package com.csuarez.microservices.hist_microservice.HistCliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/histCliente")
@RequiredArgsConstructor
@Slf4j
public class HistClienteController {

    private final HistClienteService service;
    
    @PostMapping
    public ResponseEntity<String> createCliente(@Valid @RequestBody HistClienteRequest request) {
        return ResponseEntity.ok(service.createCliente(request));
    }

}
