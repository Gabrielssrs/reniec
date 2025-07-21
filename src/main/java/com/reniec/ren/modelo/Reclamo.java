
package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_reclamo;
    
    private String nombre; 
    private String apellido;
    private String dni;
    private LocalDate fecha_registro;
    
    @Column(length = 300)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "estado_reclamo")
    private Estado estado;
}
