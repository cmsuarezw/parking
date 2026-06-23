package com.csuarez.microservices.hist_microservice.HistVehiculo;

public class HistVehiculoService {

    private final HistVehiculoRepository repository = null;
    private final HistVehiculoMapper mapper = new HistVehiculoMapper();

    public String createVehiculo(HistVehiculoRequest request) {

        var vehiculo = mapper.toVehiculo(request);
        var savedVehiculo = repository.save(vehiculo);
        return savedVehiculo.getCrud();
    }

}
