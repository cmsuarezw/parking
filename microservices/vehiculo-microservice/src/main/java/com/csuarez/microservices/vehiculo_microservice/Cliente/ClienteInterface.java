package com.csuarez.microservices.vehiculo_microservice.Cliente;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CLIENTE-MICROSERVICE")
public interface ClienteInterface {

    @GetMapping("/api/v1/clientes/{id_Cliente}")
    Optional<ClienteResponse> getClienteById(@PathVariable("id_Cliente") String id_Cliente);
    
}
