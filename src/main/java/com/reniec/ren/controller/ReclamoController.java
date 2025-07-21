package com.reniec.ren.controller;

import com.reniec.ren.modelo.Estado;
import com.reniec.ren.modelo.Reclamo;
import com.reniec.ren.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reclamos")
@CrossOrigin(origins = "*")
public class ReclamoController {

    @Autowired
    private ReclamoRepository reclamoRepository;

    @PostMapping("/registrar")
    public Reclamo registrarReclamo(@RequestBody Reclamo nuevoReclamo) {
        // Asignar el estado "registrado" (ID 1)
        Estado estado = new Estado();
        estado.setId_estado(1);
        nuevoReclamo.setEstado(estado);

        // Establecer la fecha de registro actual
        nuevoReclamo.setFecha_registro(LocalDate.now());

        return reclamoRepository.save(nuevoReclamo);
    }
}
