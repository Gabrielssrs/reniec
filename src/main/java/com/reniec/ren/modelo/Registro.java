package com.reniec.ren.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter

@Data
@Table(name = "Registro")

@Entity
public class Registro {
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_validacion;
    
    private String dni;
    private String ubigeo;
    
    @Column(name = "fecha_registro")
    private LocalDateTime date;
    
    // Establece fecha automáticamente antes de guardar
    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}
