package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.csuarez.microservices.vehiculo_microservice.Cliente.ClienteInterface;
import com.csuarez.microservices.vehiculo_microservice.Cliente.ClienteResponse;
import com.csuarez.microservices.vehiculo_microservice.exceptions.VehiculoException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehiculoService {

    private final VehiculoRepository repository;
    private final VehiculoMapper mapper = new VehiculoMapper();
    private final ClienteInterface clienteInterface;
    @Autowired
    private DiscoveryClient discoveryClient;
    private URI uri;
    private RestTemplate restTemplate;

    LocalDateTime localDatetime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /*
     *  Metodo:      getAllVehiculos
     *  Entrada:     
     *  Salida:      List<VehiculoResponse>
     *  Descripcion: Devuelve todos los vehiculos
     */
    public List<VehiculoResponse> getAllVehiculos() {
        return repository.findAll().stream()
                .map(mapper::toVehiculoResponse)
                .toList();
    }

    /*
     *  Metodo:      getVehiculoByMatricula
     *  Entrada:     
     *  Salida:      VehiculoResponse
     *  Descripcion: Devuelve un vehiculo según matricula
     */
    public VehiculoResponse getVehiculoByMatricula(String matricula) {
        VehiculoEntity vc = repository.findByMatricula(matricula)
                .orElseThrow(() -> new VehiculoException("La matricula no existe"));

        return mapper.toVehiculoResponse(vc);
    }

    /*
     *  Metodo:      getVehiculoById_Cliente
     *  Entrada:     String id_Cliente
     *               String baja
     *  Salida:      List<VehiculoResponse>
     *  Descripcion: Devuelve de un cliente todos sus vehiculos y sus acciones
     *               Baja indica si se anaden o no los vehículos dados de baja
     */  
    public List<VehiculoResponse> getVehiculosById_Cliente(String id_Cliente) {
        if (id_Cliente == null) {
            throw new VehiculoException("El id_Cliente debe estar informado");
        }
        
        //String bajaTmp = baja == null || baja.toUpperCase() != "S" ? "N" : baja.toUpperCase();

        return repository.findAll().stream()
                .filter(vehiculo -> vehiculo.getId_Cliente().equals(id_Cliente))
                //.filter(vehiculo -> vehiculo.getBaja().equals(bajaTmp))
                .map(mapper::toVehiculoResponse)
                .toList();
    }

    /*
     *  Metodo:      createVehiculo
     *  Entrada:     VehiculoRequest request
     *  Salida:      String
     *  Descripcion: Crea un vehiculo
     */
   
    public String createVehiculo(VehiculoRequest request) {

        String serviceName = "CLIENTE-MICROSERVICE";

        try {
            if (request == null) {
                throw new VehiculoException("No se han recibido datos para la creación de vehiculo");
            }      
        // Para poder seguir adelante con las pruebas
/*        
 * OpenFeign
 *
            ClienteResponse clienteResponse = clienteInterface.getClienteById(request.id_Cliente())
                        .orElseThrow(() -> new VehiculoException("no existe el cliente con Id " + request.id_Cliente()));
                        //.orElse(null);
*/                               

            List<ServiceInstance> lista = discoveryClient.getInstances(serviceName);
            URI clienteUri = (lista != null && lista.size() > 0) ? lista.get(0).getUri() : null;
log.warn("createVehiculo - clienteUri: %s".formatted(clienteUri));            
            restTemplate = new RestTemplate();
            var existe = restTemplate.getForObject(clienteUri + "/api/v1/clientes/existeCliente/" + request.id_Cliente(), String.class);
        
            if (existe == null){
                throw new VehiculoException("No existe el cliente %s".formatted(request.id_Cliente()));
            }

            VehiculoEntity vehiculoEntity = mapper.toVehiculo(request);

            //Por quitar la advertencia a falta de revision
            if (request.id_Cliente() != null){
                vehiculoEntity.setId_Cliente(request.id_Cliente());
            } else {
                throw new VehiculoException("El cliente Id no puede ser null");
            }
            
            vehiculoEntity.setFec_Baja(null);
            vehiculoEntity.setFec_Traspasado(null);
            vehiculoEntity.setDatCre(localDatetime);
            vehiculoEntity.setDatUpd(null);

            log.warn("createVehiculo - request - %s".formatted(request.toString()));
            log.warn("createVehiculo - vehiculoEntity - %s".formatted(vehiculoEntity.toString()));
            
            //return repository.save(mapper.toVehiculo(request)).getMatricula();
            var vehiculo = repository.save(vehiculoEntity);

             // Traspasamos con Kafka

            return vehiculo.getMatricula();
        }
        catch(Exception e) {
            throw new VehiculoException("VehiculoService - createVehiculo - ERROR: %s".formatted(e.toString()));

        } 
    }

    /*
     * Metodo     : updateVehiculo
     * Entrada    : VehiculoRequest
     * Salida     : String matricula
     * Descripcion: Actualiza los datos del vehiculo y devuelve la matricula una vez guardado en la tabla de vehiculos
     */
    //@SuppressWarnings("null")
    public String updateVehiculo(VehiculoRequestUpdate request) {

        // Confirmamos que la matricula existe
        var vc =repository.findByMatricula(request.matricula())
                                .filter(vehiculo -> vehiculo.getFec_Baja() == null)
                                .orElseThrow(() -> new VehiculoException("Vehiculo con matricula %s no encontrado o dado de baja".formatted(request.matricula())));
    
        if(vc.getMarca().equalsIgnoreCase(request.matricula()) && vc.getModelo().equalsIgnoreCase(request.modelo())) {
            throw new VehiculoException("El vehículo con matricula %s ya tiene informado la misma marca y modelo");
        }

        vc.setMarca(request.marca());
        vc.setModelo(request.modelo());
        vc.setFec_Traspasado(null);
        vc.setDatUpd(localDatetime);
        
        var savedVehiculo = repository.save(vc);
        //Traspasamos la actualizacion con Kafka
/*      if (savedVehiculo != null) {
            cliente.setTraspasado("S");
            savedCliente = repository.save(savedVehiculo);
        }
*/
        return savedVehiculo.getMatricula();
    }

    /*
     *  Metodo:      deleteVehiculoByMatricula
     *  Entrada:     String matricula
     *               String baja
     *               LocalDate fec_Baja
     *  Salida:      String matricula
     *  Descripcion: Borrado logico de un vehiculo
     */
    public void deleteVehiculo(String matricula, String baja) {

        baja = baja.toUpperCase();
        
        if(!"S".equals(baja) && !"N".equals(baja))
            throw new VehiculoException("Baja debe ser 'S' o 'N'");

        var vehiculo = repository.findByMatricula(matricula)
                                 .orElseThrow(() -> new VehiculoException("Vehiculo con matricula %s no encontrado".formatted(matricula)));
        
        if ("S".equalsIgnoreCase(baja) && vehiculo.getFec_Baja() != null) {
            throw new VehiculoException("El vehículo ya tiene la misma baja informada");
        }


        vehiculo.setFec_Baja("S".equals(baja) ? localDatetime : null);
        vehiculo.setFec_Traspasado(null);
        vehiculo.setDatUpd(localDatetime);

        repository.save(vehiculo);
        //Traspasamos la actualizacion con Kafka
/*      if (savedCliente != null) {
            cliente.setTraspasado("S");
            savedCliente = repository.save(cliente);
        }
*/      
        //Borrado real   
        //repository.deleteById(id_Cliente);

    }

}
