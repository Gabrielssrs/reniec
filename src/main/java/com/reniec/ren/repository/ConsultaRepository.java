package com.reniec.ren.repository;

import com.reniec.ren.modelo.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // Buscar por ID de cita
    @Query("SELECT c FROM Consulta c WHERE c.cita.idCita = :idCita")
    Consulta findByCitaId(@Param("idCita") Long idCita);
    
    // Buscar por tipo de consulta
    java.util.List<Consulta> findByTipoConsulta(String tipoConsulta);
    
    // Buscar por tipo de trámite
    java.util.List<Consulta> findByTipoTramite(String tipoTramite);
}
