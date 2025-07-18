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

    public static class BusquedaRequest {
        public String dni;
        public Long cita;
    }

    @PostMapping("/registrar")
    public String registrarConsulta(@RequestBody Consulta nuevoConsulta) {
        consultaRepository.save(nuevoConsulta);
        return "Consulta registrada correctamente con ID: " + nuevoConsulta.getId_consulta();
    }

    @GetMapping("/buscar")
    public Consulta buscarPorDniEIdCita(@RequestBody BusquedaRequest request) {
        System.out.println("Buscando consulta con DNI: " + request.dni + " e ID Cita: " + request.cita);
        Consulta resultado = consultaRepository.findByDniAndCitaId(request.dni, request.cita);
        if (resultado == null) {
            System.out.println("No se encontró consulta");
        }
        return resultado;
    }

    @GetMapping("/todas")
    public java.util.List<Consulta> obtenerTodasLasConsultas() {
        return consultaRepository.findAll();
    }
}
