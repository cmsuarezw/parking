package com.csuarez.microservices.cliente_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@FeignClient
public class ClienteMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteMicroserviceApplication.class, args);
	}

}
