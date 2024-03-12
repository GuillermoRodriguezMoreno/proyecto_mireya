package org.iesvdm.fctconnect.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="solicitud")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    @EqualsAndHashCode.Include
    private long id;

    private String descripcion;
    private String tipo; //alumno o empresa
    private String estado; //enviada, aceptada o rechazada

    @ManyToOne
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;

}
