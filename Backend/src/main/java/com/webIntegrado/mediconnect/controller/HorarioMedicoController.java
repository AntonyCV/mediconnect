package com.webIntegrado.mediconnect.controller;

import com.webIntegrado.mediconnect.model.HorarioMedico;
import com.webIntegrado.mediconnect.repository.HorarioMedicoRepository;
import com.webIntegrado.mediconnect.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioMedicoController {

    @Autowired

    private HorarioMedicoRepository horarioRepo;
    @Autowired
    private HorarioService horarioService;

    // Obtener todos los días disponibles para un médico (sin duplicados)
    @GetMapping("/dias")
    public List<String> getDiasDisponibles(@RequestParam Long medicoId) {
        return horarioRepo.findByMedicoId(medicoId)
                .stream()
                .map(HorarioMedico::getDiaSemana)
                .distinct()
                .toList();
    }

    // Obtener los turnos disponibles en un día específico para un médico
    @GetMapping("/turnos")
    public List<String> getTurnosPorDia(@RequestParam Long medicoId, @RequestParam String dia) {
        return horarioRepo.findByMedicoIdAndDiaSemana(medicoId, dia)
                .stream()
                .map(HorarioMedico::getTurno)
                .distinct()
                .toList();
    }

    // Obtener el rango de hora de un turno específico
    @GetMapping("/rango")
    public HorarioMedico getRangoHorario(
            @RequestParam Long medicoId,
            @RequestParam String dia,
            @RequestParam String turno
    ) {
        return horarioRepo.findByMedicoIdAndDiaSemana(medicoId, dia).stream()
                .filter(h -> h.getTurno().equalsIgnoreCase(turno))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/disponibles")
    public List<LocalTime> obtenerHorariosDisponibles(
            @RequestParam Long medicoId,
            @RequestParam String dia,
            @RequestParam String turno,
            @RequestParam String fecha
    ) {
        return horarioService.obtenerHorariosDisponibles(
                medicoId, dia, turno, LocalDate.parse(fecha)
        );
    }

    // Agrega esto en HorarioMedicoController
    @GetMapping
    public List<HorarioMedico> getAllHorarios() {
        return horarioRepo.findAll();
    }

}


