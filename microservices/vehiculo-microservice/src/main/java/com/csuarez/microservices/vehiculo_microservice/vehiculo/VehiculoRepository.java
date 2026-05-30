package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VehiculoRepository  extends JpaRepository<VehiculoEntity, Integer>{

    Optional<VehiculoEntity> findByMatricula(String matricula);

}
