package com.csuarez.microservices.vehiculo_microservice.accion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccionRepository  extends JpaRepository<AccionEntity, Integer>{

     Optional<AccionEntity> findByMatricula(String matricula);

}
