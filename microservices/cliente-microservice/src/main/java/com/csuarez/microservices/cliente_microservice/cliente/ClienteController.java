package com.csuarez.microservices.cliente_microservice.cliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/cliente")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private final ClienteService service;  

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getClientes() {
        return ResponseEntity.ok(service.getClientes());
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteResponse> getClienteById(@PathVariable("idCliente") String idCliente) {
        return ResponseEntity.ok(service.getClienteById(idCliente));
    }
    
    @PostMapping
    public ResponseEntity<String> createCliente(@Valid @RequestBody ClienteRequest request) {
        return ResponseEntity.ok(service.createCliente(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCliente(@Valid @RequestBody ClienteRequest request) {
        service.updateCliente(request);
        return ResponseEntity.accepted().build();
    }
    
    @DeleteMapping("/{idCliente}/{baja}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable("idCliente") String idCliente,
                                                  @PathVariable("baja") String baja) {
        service.deleteClienteById(idCliente, baja);
        return ResponseEntity.accepted().build();
    }
    
}
