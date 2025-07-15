package com.reniec.ren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reniec.ren.modelo.Validacion;
import com.reniec.ren.repository.ValidacionRepository;

@RestController
@RequestMapping("/validaciones")
public class ValidacionController {

    @Autowired
    private ValidacionRepository validacionRepository;

    @PostMapping("/registrar")
    public String registrarValidacion(@RequestBody Validacion nuevaValidacion) {
        validacionRepository.save(nuevaValidacion);
        return "Validación registrada correctamente con ID: " + nuevaValidacion.getId_validacion();
    }
}
