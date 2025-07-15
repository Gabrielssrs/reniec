
package com.reniec.ren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reniec.ren.modelo.Cita;
import com.reniec.ren.repository.CitaRepository;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;


    @GetMapping
    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }


    @PostMapping("/registrar")
    public String registrarCita(@RequestBody Cita nuevaCita) {
        citaRepository.save(nuevaCita);
        return "Cita registrada correctamente para el ciudadano con ID: " +
                nuevaCita.getId_consulta().getId_consulta();
    }

    @GetMapping("/probar")
    public String probarConexion() {
        long total = citaRepository.count(); // consulta sencilla
        return "Conectado a la BD. Total citas registradas: " + total;
    }

}
