package com.webIntegrado.mediconnect.controller;

import com.webIntegrado.mediconnect.model.Medico;
import com.webIntegrado.mediconnect.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
// permite peticiones desde cualquier origen (útil para el frontend)
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    // Obtener especialidades (opcional filtro por sede)
    @GetMapping("/especialidades")
    public List<String> obtenerEspecialidades(@RequestParam(required = false) Long sedeId) {
        if (sedeId == null) {
            return medicoRepository.findDistinctEspecialidades();
        } else {
            return medicoRepository.findEspecialidadesBySedeId(sedeId);
        }
    }

    // Obtener médicos por especialidad (sin sede)
    @GetMapping("/por-especialidad")
    public List<Medico> obtenerMedicosPorEspecialidad(@RequestParam String especialidad) {
        return medicoRepository.findByEspecialidad(especialidad);
    }

    // Obtener médicos por sede y especialidad
    @GetMapping("/por-sede-y-especialidad")
    public List<Medico> obtenerMedicosPorSedeYEspecialidad(@RequestParam Long sedeId, @RequestParam String especialidad) {
        return medicoRepository.findMedicosBySedeIdYEspecialidad(sedeId, especialidad);
    }

    // Obtener todos los médicos (opcional)
    @GetMapping
    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }
}
