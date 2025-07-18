package com.reniec.ren.controller;

import com.reniec.ren.modelo.Cita;
import com.reniec.ren.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    // POST: Registrar una nueva cita
    @PostMapping("/registrar")
    public Cita registrarCita(@RequestBody Cita nuevaCita) {
        return citaRepository.save(nuevaCita);
    }

    // GET: Obtener todas las citas
    @GetMapping
    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    // GET: Obtener una cita por ID
    @GetMapping("/{id}")
    public Cita obtenerCitaPorId(@PathVariable Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    // DELETE: Eliminar una cita por ID
    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Long id) {
        citaRepository.deleteById(id);
    }
}
