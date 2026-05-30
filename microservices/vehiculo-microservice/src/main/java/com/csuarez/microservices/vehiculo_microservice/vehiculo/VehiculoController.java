package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/vehiculo")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost")
public class VehiculoController {

    private final VehiculoService service;
    
    //@CrossOrigin(origins = "http://localhost:3000") // Solo permite peticiones desde este origen
    @GetMapping()
    public ResponseEntity<List<VehiculoResponse>> getAllVehiculos() {
        return ResponseEntity.ok(service.getAllVehiculos());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<VehiculoResponse> getVehiculoByMatricula(@Valid @PathVariable("matricula") String matricula){
        return ResponseEntity.ok(service.getVehiculoByMatricula(matricula));
    }

    @GetMapping("/{id_Cliente}")
    public  ResponseEntity<List<VehiculoResponse>> getVehiculosByid_Cliente(@Valid @PathVariable("id_Cliente") String id_Cliente){
        return ResponseEntity.ok(service.getVehiculosByid_Cliente(id_Cliente));
    }

    //@CrossOrigin // Permite desde cualquier origen (por defecto)
    @PostMapping()
    public ResponseEntity<String> createVehiculo(@RequestBody VehiculoRequest request) {
        return ResponseEntity.ok(service.createVehiculo(request));
    }

    @PutMapping()
    public ResponseEntity<String> updateVehiculo(@RequestBody VehiculoRequestUpdate request) {      
        return ResponseEntity.ok(service.updateVehiculo(request));
    }
    
    @DeleteMapping("/{matricula}/{baja}")
    public ResponseEntity<String> deleteVehiculo(@Valid @PathVariable("matricula") String matricula, 
                                                 @Valid @PathVariable("baja") String baja) {
        service.deleteVehiculo(matricula, baja);
        return ResponseEntity.accepted().build();
    }

    
}
