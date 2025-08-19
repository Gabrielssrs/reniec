package com.reniec.ren.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.reniec.ren.modelo.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Registro r WHERE r.dni = :dni AND r.ubigeo = :ubigeo")
    boolean existsByDniAndUbigeo(@Param("dni") String dni, @Param("ubigeo") String ubigeo);
}

