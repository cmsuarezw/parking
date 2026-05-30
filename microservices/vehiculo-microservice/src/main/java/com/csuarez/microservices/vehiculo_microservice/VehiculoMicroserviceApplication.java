package com.csuarez.microservices.vehiculo_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VehiculoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculoMicroserviceApplication.class, args);
	}

}
