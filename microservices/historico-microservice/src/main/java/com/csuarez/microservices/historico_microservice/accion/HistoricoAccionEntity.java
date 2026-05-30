package com.csuarez.microservices.historico_microservice.accion;

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
@Table(name="acciones")
public class HistoricoAccionEntity {

    @Id
    //Ya lo hace mediante seq en Oracle
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accion_seq")
    //@SequenceGenerator(name = "accion_seq", sequenceName = "accion_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, columnDefinition = "NUMBER")
    private Number id;

    @Column(name = "crud", nullable = false, columnDefinition = "VARCHAR2(10 CHAR)")
    private String crud;

    @Column(name = "id_Accion", nullable = false, columnDefinition = "VARCHAR2(10 CHAR)")
    private Number id_Accion;

    @Column(name = "matricula", nullable = false, columnDefinition = "VARCHAR(10)")
    private String matricula;
    
    //@Transient
    @Column(name = "fec_Entrada", nullable = false, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    public LocalDateTime fec_Entrada; // = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

    //@Transient
    @Column(name = "fec_Salida", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    public LocalDateTime fec_Salida;

    //@Transient
    @Column(name = "fec_Create", nullable = false, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    public LocalDateTime fec_Create;

    //@Transient
    @Column(name = "fec_Update", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    public LocalDateTime fec_Update;

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
