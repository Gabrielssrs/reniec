package com.reniec.ren.controller;

import com.reniec.ren.modelo.Estado;
import com.reniec.ren.modelo.Reclamo;
import com.reniec.ren.repository.EstadoRepository;
import com.reniec.ren.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/reclamos")
@CrossOrigin(origins = "*")
public class ReclamoController {

    @Autowired
    private ReclamoRepository reclamoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping("/registrar")
    public Reclamo registrarReclamo(@RequestBody Reclamo nuevoReclamo) {
        // Buscar el estado "registrado" (ID 1)
        Estado estado = estadoRepository.findById(1)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "El estado 'registrado' no se encuentra en la base de datos."));
        
        nuevoReclamo.setEstado(estado);

        // Establecer la fecha de registro actual
        nuevoReclamo.setFecha_registro(LocalDate.now());

        return reclamoRepository.save(nuevoReclamo);
    }
}
