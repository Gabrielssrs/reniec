
package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cita;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date fecha;
    private Integer estado;
    private Double pago;
    private String tipo;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta id_consulta;
    

}