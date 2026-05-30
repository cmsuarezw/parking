package com.csuarez.microservices.historico_microservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csuarez.microservices.historico_microservice.accion.HistoricoAccionRequest;
import com.csuarez.microservices.historico_microservice.cliente.HistoricoClienteRequest;
import com.csuarez.microservices.historico_microservice.vehiculo.HistoricoVehiculoRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/historico")
@RequiredArgsConstructor
public class HistoricoController {

     private final HistoricoService historicoService;

    @PostMapping("/cliente/{accion}")
    public ResponseEntity<String> createHistoricoCliente(@Valid @PathVariable("accion") String accion,
                                                         @Valid @RequestBody HistoricoClienteRequest request) {
            return ResponseEntity.ok(historicoService.createHistoricoCliente(accion, request));
        }

    @PostMapping("/vehiculo/{accion}")
    public ResponseEntity<String> createHistoricoVehiculo(@Valid @PathVariable("accion") String accion,
                                                         @Valid @RequestBody HistoricoVehiculoRequest request) {
            return ResponseEntity.ok(historicoService.createHistoricoVehiculo(accion, request));
        }

    @PostMapping("/accion/{accion}")
    public ResponseEntity<String> createHistoricoAccion(@Valid @PathVariable("accion") String accion,
                                                         @Valid @RequestBody HistoricoAccionRequest request) {
            return ResponseEntity.ok(historicoService.createHistoricoAccion(accion, request));
        }
    
}
