package com.csuarez.microservices.historico_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class HistoricoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoricoMicroserviceApplication.class, args);
	}

}
