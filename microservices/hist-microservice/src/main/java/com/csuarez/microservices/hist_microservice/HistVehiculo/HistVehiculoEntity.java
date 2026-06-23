package com.csuarez.microservices.hist_microservice.HistVehiculo;


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
public class HistVehiculoEntity {
    @Id
    @GeneratedValue
    private int id;
    private String crud;
    private String matricula;
    private String idCliente;
    private String marca;
    private String modelo;
    private LocalDateTime fecBaja;
    private LocalDateTime fecTraspasado;
    @CreatedDate
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date DatCre;
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date DatUpd;
}
