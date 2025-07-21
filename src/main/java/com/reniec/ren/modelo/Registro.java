package com.reniec.ren.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Data
@Table(name = "Registro")

@Entity
public class Registro {
       
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id_validacion;
       String dni;
       String ubigeo;
       LocalDateTime date;
}
