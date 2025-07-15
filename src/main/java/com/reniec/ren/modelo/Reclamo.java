
package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamo {

    @Id
    private Integer id_reclamo;

    @Column(length = 300)
    private String descripcion;

    private Date fecha_registro;
    private Integer estado_reclamo;
    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "id_ciudadano")
    private Consulta ciudadano;
}