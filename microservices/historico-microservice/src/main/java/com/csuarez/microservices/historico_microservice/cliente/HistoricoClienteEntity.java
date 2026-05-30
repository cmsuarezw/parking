package com.csuarez.microservices.historico_microservice.cliente;

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
@Table(name="clientes")
public class HistoricoClienteEntity {

    @Id
    //Ya se genera por seq en Oracle
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    //@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, columnDefinition = "NUMBER")
    private Number id;

    @Column(name = "crud", nullable = false, columnDefinition = "VARCHAR2(50 CHAR)")
    private String crud;

    @Column(name = "id_Cliente", nullable = false, columnDefinition = "VARCHAR2(100 CHAR)")
    private String id_Cliente;

    @Column(name = "dni", nullable = false, columnDefinition = "VARCHAR2(10 CHAR)")
    private String dni;    

    @Column(name = "nombre", nullable = false, columnDefinition = "VARCHAR2(50 CHAR)")
    private String nombre;

    @Column(name = "apellidos", nullable = false, columnDefinition = "VARCHAR2(100 CHAR)")
    private String apellidos;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR2(100 CHAR)")
    private String email;

    @Column(name = "telefono", nullable = true, columnDefinition = "VARCHAR2(10 CHAR)")
    private String telefono;

    @Column(name = "ciudad", nullable = true, columnDefinition = "VARCHAR2(5 CHAR)")
    private String ciudad;

    @Column(name = "fec_Create", nullable = false, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fec_Create;

    @Column(name = "fec_Update", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fec_Update;

    @Column(name = "fec_Baja", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fec_Baja;

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
