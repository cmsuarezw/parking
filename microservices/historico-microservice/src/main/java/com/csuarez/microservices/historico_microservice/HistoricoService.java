package com.csuarez.microservices.historico_microservice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.csuarez.microservices.historico_microservice.cliente.HistoricoClienteEntity;
import com.csuarez.microservices.historico_microservice.cliente.HistoricoClienteMapper;
import com.csuarez.microservices.historico_microservice.cliente.HistoricoClienteRepository;
import com.csuarez.microservices.historico_microservice.cliente.HistoricoClienteRequest;

import com.csuarez.microservices.historico_microservice.vehiculo.HistoricoVehiculoEntity;
import com.csuarez.microservices.historico_microservice.vehiculo.HistoricoVehiculoMapper;
import com.csuarez.microservices.historico_microservice.vehiculo.HistoricoVehiculoRepository;
import com.csuarez.microservices.historico_microservice.vehiculo.HistoricoVehiculoRequest;

import com.csuarez.microservices.historico_microservice.accion.HistoricoAccionEntity;
import com.csuarez.microservices.historico_microservice.accion.HistoricoAccionMapper;
import com.csuarez.microservices.historico_microservice.accion.HistoricoAccionRepository;
import com.csuarez.microservices.historico_microservice.accion.HistoricoAccionRequest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.csuarez.microservices.historico_microservice.exceptions.HistoricoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoricoService {

    private final HistoricoClienteRepository clienteRepository;
    private final HistoricoClienteMapper clienteMapper = new HistoricoClienteMapper();
    //
    private final HistoricoVehiculoRepository vehiculoRepository;
    private final HistoricoVehiculoMapper vehiculoMapper = new HistoricoVehiculoMapper();
    //
    private final HistoricoAccionRepository accionRepository;
    private final HistoricoAccionMapper accionMapper = new HistoricoAccionMapper();
    //
    LocalDateTime localDatetime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @PersistenceContext
    private EntityManager entityManager;
/*
 * Ya lo hace Oracle mediante seq
 *
    public Long getNextId() {
        return ((Number) entityManager.createNativeQuery("SELECT contador_seq.NEXTVAL FROM dual").getSingleResult()).longValue();
    }
 */
    /*
     *  Metodo:      createHistoricoCliente
     *  Entrada:     Json con los datos de cliente más la accion que se ha realizado
     *  Salida:      String
     *  Descripcion: Crea un cliente en la tabla de cliente
     */
    public String createHistoricoCliente(String accion, HistoricoClienteRequest request) {
        try {
            if (request == null) {
                throw new HistoricoException("No se han recibido datos para el CRUD de cliente");
            }
            HistoricoClienteEntity cliente = clienteMapper.toHistoricoClienteEntity(request);
//            cliente.setId(getNextId());
            cliente.setCrud(accion);
            var savedCliente = clienteRepository.save(cliente);
            return savedCliente.getId().toString();
        } catch(Exception e) {
            throw new HistoricoException("Historico $s - ERROR: %s".formatted("Cliente",e.toString()));
        }
    }


    /*
     *  Metodo:      createHistoricoVehiculo
     *  Entrada:     Json con los datos de vehiculo más la accion que se ha realizado
     *  Salida:      String
     *  Descripcion: Crea un vehiculo en la tabla de vehiculo
     */
    public String createHistoricoVehiculo(String accion, HistoricoVehiculoRequest request) {
        try {
            if (request == null) {
                throw new HistoricoException("No se han recibido datos para el CRUD de vehiculo");
            }
            HistoricoVehiculoEntity vehiculo = vehiculoMapper.toHistoricoVehiculoEntity(request);
 //           vehiculo.setId(getNextId());
            vehiculo.setCrud(accion);
            var savedVehiculo = vehiculoRepository.save(vehiculo);
            return savedVehiculo.getId().toString();
        } catch(Exception e) {
            throw new HistoricoException("Historico %s - ERROR: %s".formatted("Vehiculo", e.toString()));
        }
    }

    /*
     *  Metodo:      createHistoricoAccion
     *  Entrada:     Json con los datos de accion de un vehiculo en un parking
     *  Salida:      String
     *  Descripcion: Crea un accion de vehiculo en la tabla de accion
     */
    public String createHistoricoAccion(String accion, HistoricoAccionRequest request) {
        try {
            if (request == null) {
                throw new HistoricoException("No se han recibido datos para el CRUD de accion de vehículo");
            }

            HistoricoAccionEntity accionES = accionMapper.toHistoricoAccionEntity(request);
//            accionES.setId(getNextId());

            
            var savedAccion = accionRepository.save(accionES);

            return savedAccion.getId().toString();
        } catch(Exception e) {
            throw new HistoricoException("Historico %s - ERROR: %s".formatted("AccionES", e.toString()));
        }
    }

}
