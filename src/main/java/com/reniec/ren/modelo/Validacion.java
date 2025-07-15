package com.reniec.ren.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data

@Entity
public class Validacion {
       
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id_validacion;
       String dni;
       String ubigeo;


}
