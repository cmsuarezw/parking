package com.csuarez.microservices.hist_microservice.HistCliente;

public class HistClienteService {

    private final HistClienteRepository repository = null;
    private final HistClienteMapper mapper = new HistClienteMapper();

    public String createCliente(HistClienteRequest request) {

        var cliente = mapper.toCliente(request);
        var savedCliente = repository.save(cliente);
        return savedCliente.getCrud() + " - " + savedCliente.getIdCliente();
    }

}
