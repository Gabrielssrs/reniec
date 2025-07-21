package com.reniec.ren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reniec.ren.modelo.Registro;
import com.reniec.ren.repository.RegistroRepository;

@RestController
@RequestMapping("/registro")
@CrossOrigin(origins = "*") 
public class RegistroController {

    @Autowired
    private RegistroRepository validacionRepository;

    @PostMapping("/registrar")
    public String registrarValidacion(@RequestBody Registro nuevaValidacion) {
        validacionRepository.save(nuevaValidacion);
        return "Registro registrada correctamente con ID: " + nuevaValidacion.getId_validacion();
    }
}
