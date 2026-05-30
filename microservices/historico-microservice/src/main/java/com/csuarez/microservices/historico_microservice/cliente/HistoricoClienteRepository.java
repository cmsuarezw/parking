package com.csuarez.microservices.historico_microservice.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoClienteRepository extends JpaRepository<HistoricoClienteEntity, Long>{
/*
    @Query(value = "SELECT cliente_seq.NEXTVAL FROM dual", nativeQuery = true)
    static
    Long getNextSequenceValue() {
        throw new UnsupportedOperationException("Unimplemented method 'getNextSequenceValue'");
    }
*/
}
