package com.csuarez.microservices.cliente_microservice.cliente;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Document
public class ClienteEntity {
    @Id
    private String idCliente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String ciudad;
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private String fec_Create;
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private String fec_Update;
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private String fec_Baja;
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private String fec_Traspasado;
    @CreatedDate
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private String DatCre;
    private String DatUpd;
}
