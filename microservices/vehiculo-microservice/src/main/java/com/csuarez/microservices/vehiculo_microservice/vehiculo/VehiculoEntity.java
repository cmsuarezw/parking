package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="vehiculo") //, uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames="email_adress"))
@Slf4j
public class VehiculoEntity {
/*
    @Builder.Default
    private DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Builder.Default
    private DateFormatter formatterDate = DateFormatter.ofPattern("dd-MM-yyyy");
    @Builder.Default
    private DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
*/   

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "matricula", nullable = false, columnDefinition = "VARCHAR(10)", unique = true)
    private String matricula;

    @Column(name = "id_Cliente", nullable = false, columnDefinition = "VARCHAR(100)")
    private String id_Cliente;

    @Column(name = "marca" , nullable = false, columnDefinition = "VARCHAR(10)")
    private String marca;

    @Column(name = "modelo", nullable = false, columnDefinition = "VARCHAR(20)")
    private String modelo;

    //@Transient
    @Column(name = "fec_Baja", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Baja;
    
    //@Transient
    @Column(name = "fec_Traspasado", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Traspasado;

    //@Transient
    @Column(name = "datCre", nullable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime datCre;

    //@Transient
    @Column(name = "datUpd", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime datUpd;
/*    
    @Override
    public String toString() {
        return "Vehiculo{"        +
               "id_matricula = "  + this.getId()         + "\n"  +
               ", matricula = '"  + this.getMatricula()  + "'\n" +
               ", id_Cliente = '"  + this.getId_Cliente()  + "'\n" +
               ", marca = '"      + this.getMarca()      + "'\n" +
               ", modelo = '"     + this.getModelo()     + "'\n" +
               ", fecBaja = "     + this.getFec_Baja().toString() + "\n" +
               ", fecCreate = "   + this.getFec_Create().toString()  + "\n" +
               ", fecUpdate = "   + this.getFec_Update().toString()  + "\n" +
               ", traspasado = '" + this.getFec_Traspasado().toString() + "'\n" +
               "}";
    }
*/
}
