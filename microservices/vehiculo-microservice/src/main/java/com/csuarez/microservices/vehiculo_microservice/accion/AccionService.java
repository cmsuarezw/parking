package com.csuarez.microservices.vehiculo_microservice.accion;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.csuarez.microservices.vehiculo_microservice.exceptions.VehiculoException;
//import com.csuarez.microservices.vehiculo_microservice.vehiculo.VehiculoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccionService {

//    private final VehiculoRepository repositoryVehiculo;
//    private final AccionRepository repositoryAccion;
    //private final AccionMapper mapper = new AccionMapper();

    LocalDate hoy = LocalDate.now();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    String localDate = df.format(hoy);

    LocalDateTime localDatetime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /*
     *  Metodo:      vehiculoAccion
     *  Entrada:     matricula
     *  Salida:      Integer
     *  Descripcion: Crea una entrada en un supuesto parking de un vehículo
     */
    public String vehiculoAccion(String matricula, String accion) {

        accion = accion.toUpperCase();

        if (!accion.equalsIgnoreCase("ENTRADA") || !accion.equalsIgnoreCase("SALIDA")){
                throw new VehiculoException("Accion debe de estar 'ENTRADA' o 'SALIDA'"); 
            }
 /*       

        var existeVehiculo = repositoryVehiculo.findAll().stream()
                                               .filter(vehiculo -> vehiculo.getMatricula().equals(matricula));
        
        if(existeVehiculo == null || existeVehiculo.toString().isBlank() || existeVehiculo.toString().isEmpty()) {
            throw new VehiculoException("Vehiculo con matricula %s no encontrado o dado de baja".formatted(matricula));
        }
        // Si lo encuentra, comprobamos si ya está dentro del parking y no ha salido
        var existeDentro = repositoryAccion.findByMatricula(matricula)
                                           .filter(accion -> accion.getFecSalida().equals(null))
                                           .orElseThrow(() -> new VehiculoException("Vehiculo con matricula %s no encontrado o ya se encuentra dentro del parking".formatted(matricula)));

        if (existeDentro == null) {
            existeDentro = new AccionEntity();
            existeDentro.setMatricula(matricula);
            existeDentro.setFecEntrada(localDatetime);
        } else {
            existeDentro.setFecSalida(localDatetime);
        }

        existeDentro.setTraspasado("N");

        var savedAccion = repositoryAccion.save(existeDentro);

        
        return savedAccion.getVehiculo() + " - Entrada: " + savedAccion.getFecEntrada().toString()
                + " - Salida: " + savedAccion.getFecSalida().toString();
*/
        return matricula;                
    }

}
