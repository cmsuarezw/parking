package com.csuarez.microservices.vehiculo_microservice.accion;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
//import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="accion")
@Slf4j
public class AccionEntity {
/*
    @Builder.Default
    private DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    @Builder.Default
    private DateTimeFormatter formatterDate     = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Builder.Default
    private DateTimeFormatter formatterTime     = DateTimeFormatter.ofPattern("HH:mm:ss");
*/
    @Id
    @GeneratedValue
    //@SequenceGenerator(name="accion_sequence", sequenceName = "accion_seq", allocationSize = 1)
    //@GeneratedValue(generator = "accion_sequence", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "matricula", nullable = false, columnDefinition = "VARCHAR(10)")
    private String matricula;
    
    //@Transient
    @Column(name = "fec_Entrada", nullable = false, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Entrada; // = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

    //@Transient
    @Column(name = "fecSalida", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Salida;

    //@Transient
    @Column(name = "fec_Traspasado", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Traspasado;

    @Column(name = "DatCre", nullable = false, columnDefinition = "DATE")
    @CreatedDate
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private LocalDate DatCre;

    @Column(name = "DatUpd", nullable = true, columnDefinition = "DATE")
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private LocalDate DatUpd;

}
