package com.csuarez.microservices.historico_microservice.vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoVehiculoRepository extends JpaRepository<HistoricoVehiculoEntity, Long>{

}
