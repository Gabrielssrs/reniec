package com.reniec.ren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reniec.ren.modelo.Consulta;
import com.reniec.ren.repository.ConsultaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping("/registrar")
    public String registrarConsulta(@RequestBody Consulta nuevoConsulta) {
        consultaRepository.save(nuevoConsulta);
        return "Consulta registrada correctamente con ID: " + nuevoConsulta.getId_consulta();
    }

    @GetMapping("/buscar")
    public Consulta buscarPorDniEIdCita(@RequestParam String dni, @RequestParam Long idCita) {
        return consultaRepository.findByDniAndCita_id_cita(dni, idCita);
    }
}