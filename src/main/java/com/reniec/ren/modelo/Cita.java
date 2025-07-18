package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cita;

    // Nuevos atributos personales
    private String nombres;
    private String apellidos;
    private String numero_documento;
    private String correo_electronico;
    private String numero_telefono;

    
}