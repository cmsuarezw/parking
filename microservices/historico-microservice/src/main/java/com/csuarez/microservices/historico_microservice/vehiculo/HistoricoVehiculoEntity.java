package com.csuarez.microservices.historico_microservice.vehiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import org.hibernate.annotations.ColumnDefault;
//import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
//import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Entity
@Table(name="vehiculos")
public class HistoricoVehiculoEntity {

    @Id
    //Ya se genera por seq en Oracle 
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
    //@SequenceGenerator(name = "vehiculo_seq", sequenceName = "vehiculo_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, columnDefinition = "NUMBER")
    private Number id;

    @Column(name = "crud", nullable = false, columnDefinition = "VARCHAR2(10 CHAR)")
    private String crud;

    @Column(name = "idMatricula", nullable = false, columnDefinition = "NUMBER")
    private Number idMatricula;
    
    @Column(name = "idCliente", nullable = false, columnDefinition = "VARCHAR2(100 CHAR)")
    private String idCliente;

    @Column(name = "matricula", nullable = false, columnDefinition = "VARCHAR2(10 CHAR)")
    private String matricula;

    @Column(name = "marca", nullable = true, columnDefinition = "VARCHAR2(10 CHAR)")
    private String marca;

    @Column(name = "modelo", nullable = true, columnDefinition = "VARCHAR2(20 CHAR)")
    private String modelo;

    @Column(name = "fecCreate", nullable = false, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fecCreate;

    @Column(name = "fecUpdate", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fecUpdate;

    @Column(name = "fecBaja", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fecBaja;

    @Column(name = "DatCre", nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private LocalDate DatCre;

    @Column(name = "DatUpd", nullable = true, columnDefinition = "DATE")
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private LocalDate DatUpd;

    @PrePersist
    public void prePersist() {
    }

}
