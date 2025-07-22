package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    // Atributos personales
    private String nombres;
    private String apellidos;
    private String numero_documento;
    private String correo_electronico;
    private String numero_telefono;
    
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
    }

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    
}
