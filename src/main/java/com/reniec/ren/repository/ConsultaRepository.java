package com.reniec.ren.repository;

import com.reniec.ren.modelo.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // JpaRepository ya incluye findById() y save()
}
