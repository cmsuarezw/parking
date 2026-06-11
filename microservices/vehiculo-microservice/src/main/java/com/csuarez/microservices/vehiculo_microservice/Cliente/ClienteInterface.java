package com.csuarez.microservices.vehiculo_microservice.Cliente;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CLIENTE-MICROSERVICE")//, url="http://cliente-microservice:8091")//, path = "/api/v1/clientes")
                //url = "http://cliente-microservice:8091/api/v1/clientes")
public interface ClienteInterface {

    //@RequestMapping(value = "/api/v1/clientes/{id_Cliente}", method = RequestMethod.GET)
    @GetMapping("/api/v1/clientes/{id_Cliente}")
    Optional<ClienteResponse> getClienteById(@PathVariable("id_Cliente") String id_Cliente);
    
}
