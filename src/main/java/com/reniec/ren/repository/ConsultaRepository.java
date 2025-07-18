package com.reniec.ren.repository;



import com.reniec.ren.modelo.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Consulta findByDniAndIdCita(String dni, Long id_cita);
}
