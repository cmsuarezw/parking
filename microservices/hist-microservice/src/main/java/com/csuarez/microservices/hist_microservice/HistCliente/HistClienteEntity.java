package com.csuarez.microservices.hist_microservice.HistCliente;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HistClienteEntity {

    @Id
    @GeneratedValue
    private int id;
    private String crud;
    private String idCliente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String ciudad;
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fecBaja;
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fecTraspasado;
    @CreatedDate
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date DatCre;
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date DatUpd;
    
}
