package com.reniec.ren.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reniec.ren.modelo.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}

