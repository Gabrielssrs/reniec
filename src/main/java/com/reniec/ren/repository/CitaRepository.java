package com.reniec.ren.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.reniec.ren.modelo.Cita;
import com.reniec.ren.modelo.Consulta;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
	Consulta findByDniAndCita_IdCita(String dni, Integer id_cita);
}
