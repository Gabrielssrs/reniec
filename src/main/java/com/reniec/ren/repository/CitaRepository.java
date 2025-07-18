package com.reniec.ren.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.reniec.ren.modelo.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    // Métodos personalizados aquí si necesitas buscar por campos de Cita
}
