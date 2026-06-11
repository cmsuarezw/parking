package com.csuarez.microservices.cliente_microservice.cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository <ClienteEntity, String> {
}
