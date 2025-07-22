package com.reniec.ren.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.reniec.ren.modelo.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    Optional<Cita> findByNumero_documento(String numero_documento);
}

