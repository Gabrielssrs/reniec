package com.reniec.ren.controller;

import com.reniec.ren.modelo.Cita;
import com.reniec.ren.modelo.Estado;
import com.reniec.ren.modelo.Funcionario;
import com.reniec.ren.modelo.Oficina;
import com.reniec.ren.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    // POST: Registrar una nueva cita
    @PostMapping("/registrar")
    public Cita registrarCita(@RequestBody Cita nuevaCita) {
        Random random = new Random();

        // Asignar un funcionario aleatorio (ID entre 1 y 8)
        Funcionario funcionario = new Funcionario();
        funcionario.setId_funcionario(random.nextInt(8) + 1);
        nuevaCita.setFuncionario(funcionario);

        // Asignar una oficina aleatoria (ID entre 1 y 8)
        Oficina oficina = new Oficina();
        oficina.setId_oficina(random.nextInt(8) + 1);
        nuevaCita.setOficina(oficina);

        // Asignar el estado "registrado" (ID 1)
        Estado estado = new Estado();
        estado.setId_estado(1);
        nuevaCita.setEstado(estado);

        System.out.println("Datos recibidos: " + nuevaCita);
        Cita citaGuardada = citaRepository.save(nuevaCita);
        System.out.println("Cita guardada con ID: " + citaGuardada.getIdCita());
        return citaGuardada;
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

    // GET: Obtener una cita por DNI
    @GetMapping("/buscar")
    public Cita obtenerCitaPorDni(@RequestParam String dni) {
        return citaRepository.findByNumero_documento(dni)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró una cita con el DNI proporcionado."));
    }
}
