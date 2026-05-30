package com.csuarez.microservices.vehiculo_microservice.vehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import com.csuarez.microservices.vehiculo_microservice.accion.AccionEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Builder.Default
    private DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Builder.Default
    private DateFormatter formatterDate     = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Builder.Default
    private DateTimeFormatter formatterTime     = DateTimeFormatter.ofPattern("HH:mm:ss");
   

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
    @Column(name = "fec_Create", nullable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Create;

    //@Transient
    @Column(name = "fec_Update", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Update;

    //@Transient
    @Column(name = "fec_Baja", nullable = true, columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "DD-MM-YYYY HH:MI:SS")
    private LocalDateTime fec_Baja;
    
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

    @OneToMany(mappedBy="vehiculo", fetch=FetchType.LAZY)
    private List<AccionEntity> acciones;
    
    @Override
    public String toString() {
        return "Vehiculo{"        +
               "id_matricula = "  + this.getId()         + "\n"  +
               ", matricula = '"  + this.getMatricula()  + "'\n" +
               ", id_Cliente = '"  + this.getId_Cliente()  + "'\n" +
               ", marca = '"      + this.getMarca()      + "'\n" +
               ", modelo = '"     + this.getModelo()     + "'\n" +
               ", fecBaja = "     + this.getFec_Baja()    + "\n" +
               ", fecCreate = "   + this.getFec_Create()  + "\n" +
               ", fecUpdate = "   + this.getFec_Update()  + "\n" +
               ", traspasado = '" + this.getFec_Traspasado() + "'\n" +
               "}";
    }

}
