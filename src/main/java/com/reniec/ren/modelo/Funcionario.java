

package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    private Integer id_funcionario;

    private String nombre_completo;
    private String telefono;
    private String cargo;
    private String correo;
    private String dni;

    @ManyToOne
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;
}



