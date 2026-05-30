package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

import org.springframework.stereotype.Service;

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

    LocalDate hoy = LocalDate.now();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    String localDate = df.format(hoy);

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
     *  Metodo:      getVehiculoByid_Cliente
     *  Entrada:     String id_Cliente
     *               String baja
     *  Salida:      List<VehiculoResponse>
     *  Descripcion: Devuelve de un cliente todos sus vehiculos y sus acciones
     *               Baja indica si se anaden o no los vehículos dados de baja
     */  
    public List<VehiculoResponse> getVehiculosByid_Cliente(String id_Cliente) {
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
        try {
            if (request == null) {
                throw new VehiculoException("No se han recibido datos para la creación de vehiculo");
            }      

            ClienteResponse clienteResponse = clienteInterface.getClienteById(request.id_Cliente())
                        //.orElseThrow(() -> new VehiculoException("no existe el cliente con Id " + request.id_Cliente()))
                        .orElse(null);

            VehiculoEntity vehiculoEntity = mapper.toVehiculo(request);

            //Por quitar la advertencia
            vehiculoEntity.setId_Cliente(clienteResponse.id_Cliente());
            vehiculoEntity.setFec_Create(localDatetime);
            vehiculoEntity.setFec_Baja(null);
            vehiculoEntity.setFec_Update(null);
            vehiculoEntity.setFec_Traspasado(null);
            vehiculoEntity.setDatCre(hoy);
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
        vc.setFec_Update(localDatetime);
        vc.setFec_Traspasado(null);
        vc.setDatUpd(hoy);
        
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
        vehiculo.setFec_Update(localDatetime);
        vehiculo.setFec_Traspasado(null);
        vehiculo.setDatUpd(hoy);

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
