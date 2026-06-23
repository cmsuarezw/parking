package com.csuarez.microservices.cliente_microservice.cliente;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.csuarez.microservices.cliente_microservice.exceptions.ClienteException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    String localDate = df.format(d);

    LocalDateTime localDatetime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    /**
     * Calcula la letra correspondiente a un número de DNI.
     */
    public char calcularLetra(int numeroDni) {
        int resto = numeroDni % 23;
        return LETRAS_DNI.charAt(resto);
    }

    /**
     * Valida si el DNI completo (número + letra) es correcto.
     */
    public boolean validarDni(String dniCompleto) {
        if (dniCompleto == null || dniCompleto.length() != 9) {
            return false;
        }
        String numeroStr = dniCompleto.substring(0, 8);
        char letraProporcionada = Character.toUpperCase(dniCompleto.charAt(8));
        
        try {
            int numeroDni = Integer.parseInt(numeroStr);
            return calcularLetra(numeroDni) == letraProporcionada;
        } catch (NumberFormatException e) {
            return false; // El número no es válido
        }
    }

    /*
        Genera un DNI aleatorio
     */
    public static String generarDniAleatorio() {
        Random random = new Random();
        // Genera un número de 8 dígitos (entre 0 y 99999999)
        int numeroDni = random.nextInt(100000000); 
        
        // Asegurar que tenga 8 dígitos (opcional, rellena con ceros a la izquierda)
        String numeroFormateado = String.format("%08d", numeroDni);

        //Obtenemos la letra
        char letra = LETRAS_DNI.charAt(numeroDni % 23);

        return numeroFormateado + letra;
    }
 
    /*
     * Metodo     : getClientes
     * Entrada    :
     * Salida     : List<ClienteResponse>
     * Descripcion: Devuelve una lista con los datos de todos los clientes
     * 
     */
    public List<ClienteResponse> getClientes() {
        return repository.findAll().stream()
                .map(mapper::toClienteResponse)
                .toList();
    }

    /*
     * Metodo     : getClienteById
     * Entrada    : id_Cliente
     * Salida     : ClienteResponse o error
     * Descripcion: Devuelve los datos de un cliente
     * 
     */
    public ClienteResponse getClienteById(String idCliente) {
        if (idCliente == null) {
            throw new ClienteException("El ID de cliente debe de estar informado");
        }
        return repository.findById(idCliente)
                    .map(mapper::toClienteResponse)
                    .orElseThrow(() -> new ClienteException("Cliente con id %s no encontrado".formatted(idCliente)));
    }

    /*
     * Metodo     : createCliente
     * Entrada    : ClienteRequest
     * Salida     : String id_Cliente o error
     * Descripcion: Devuelve el id_Cliente de un cliente una vez guardado en la tabla de clientes 
     */
    public String createCliente(ClienteRequest request) {
        if(request == null) {
            throw new ClienteException("No se han recibido datos para la creación de cliente");
        }

        var cliente = mapper.toCliente(request);

        if(cliente.getDni() == null) {
            cliente.setDni(generarDniAleatorio());
        } else {
            if (validarDni(cliente.getDni()) != false) {
                cliente.setDni(cliente.getDni());
            } else {
                throw new ClienteException("El dni del cliente no es correcto");
            };
        }

        cliente.setFecBaja("");
        cliente.setFecTraspasado("");
        cliente.setDatCre(localDate);
        cliente.setDatUpd("");

        var savedCliente = repository.save(cliente);

// traspasamos
/*      if (savedCliente != null) {

        }
*/
        return savedCliente.getIdCliente();
    }

    /*
     * Metodo     : updateCliente
     * Entrada    : ClienteRequest
     * Salida     : 
     * Descripcion: Actualiza los datos del cliente y devuelve el id_Cliente una vez guardado en la tabla de clientes
     * 
     */
 //   @SuppressWarnings({ "null unused", "unused" })
    public String updateCliente(ClienteRequest request) {
        if (request == null) {
            throw new ClienteException("No se han recibido datos para la creación de cliente");
        }

        if (request.idCliente() == null) {
            throw new ClienteException("El Id de Cliente debe de estar informado");
        }

        //Comprobamos si existe el id cliente
        var cl = repository.findById(request.idCliente())
                    .orElseThrow(() -> new ClienteException("Cliente con id %s no encontrado".formatted(request.idCliente())));

        var cliente = mapper.toCliente(request);

        cliente.setFecBaja(cl.getFecBaja());
        cliente.setFecTraspasado(cl.getFecTraspasado());
        cliente.setDatCre(cl.getDatCre());
        cliente.setDatUpd(localDate);

        var savedCliente = repository.save(cliente);
        //Traspasamos la actualizacion
/*      if (savedCliente != null) {
            cliente.setTraspasado("S");
            savedCliente = repository.save(cliente);
        }
*/
       return savedCliente.getIdCliente();
    }

    /*
     * Metodo     : deleteClienteById
     * Entrada    : id_Cliente
     * Salida     : 
     * Descripcion: Si baja no está informado Actualiza los datos del cliente y devuelve el id_Cliente una vez guardado en la tabla de clientes
     * 
     */
    //@SuppressWarnings("unused")
    public void deleteClienteById(String idCliente, String baja) {
        if (idCliente == null || idCliente.isBlank())
            throw new ClienteException("El Id de cliente debe estar informado");

        if (baja == null || baja.isBlank())
            throw new ClienteException("Baja debe estar informada");

        baja = baja.toUpperCase();
        
        if(!"S".equals(baja) && !"N".equals(baja))
            throw new ClienteException("Baja debe ser 'S' o 'N'");

        var cliente =repository.findById(idCliente)
                               .orElseThrow(() -> new ClienteException("Cliente con id %s no encontrado".formatted(idCliente)));
        
        if ("S".equals(baja) && cliente.getFecBaja() != null)
            throw new ClienteException("El cliente ya se encuentra de baja");

        cliente.setFecBaja(("S".equals(baja) ? localDatetime.format(formatter) : ""));
        cliente.setFecTraspasado("");
        cliente.setDatUpd(localDate);

        repository.save(cliente);
        //Traspasamos la actualizacion
/*      if (savedCliente != null) {
            cliente.setTraspasado("S");
            savedCliente = repository.save(cliente);
        }
*/      
        //Borrado real   
        //repository.deleteById(id_Cliente);
    }

}
