package com.reniec.ren.repository;

import com.reniec.ren.modelo.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query("SELECT c FROM Consulta c WHERE c.dni = :dni AND c.cita.idCita = :idCita")
    Consulta findByDniAndCitaId(@Param("dni") String dni, @Param("idCita") Long idCita);
}
