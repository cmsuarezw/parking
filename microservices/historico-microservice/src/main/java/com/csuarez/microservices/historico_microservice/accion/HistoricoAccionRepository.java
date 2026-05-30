package com.csuarez.microservices.historico_microservice.accion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoAccionRepository extends JpaRepository<HistoricoAccionEntity, Integer>{

}
