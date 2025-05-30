package com.webIntegrado.mediconnect.controller;

import com.webIntegrado.mediconnect.model.CitaConDetalles;
import com.webIntegrado.mediconnect.model.CitaRequest;
import com.webIntegrado.mediconnect.model.Usuario;
import com.webIntegrado.mediconnect.repository.PacienteRepository;
import com.webIntegrado.mediconnect.repository.UsuarioRepository;
import com.webIntegrado.mediconnect.service.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PacienteRepository pacienteRepo;


    @PostMapping("/reservar")
    public ResponseEntity<String> reservarCita(@RequestBody CitaRequest request, Authentication auth) {
        String email = auth.getName();
        Usuario usuario = usuarioRepo.findByEmailOrUsername(email, email).orElseThrow();

        Long pacienteId = pacienteRepo.findByUsuarioId(usuario.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado")).getId_paciente();

        String mensaje = citaService.reservarCita(
                pacienteId,
                request.getMedicoId(),
                request.getSedeId(),       // <-- agregado aquí
                request.getFechaHora(),
                request.getMotivo()
        );

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/mis-citas")
    public ResponseEntity<List<CitaConDetalles>> obtenerMisCitas() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // Buscar usuario autenticado por username o email
        Optional<Usuario> usuarioOpt = usuarioRepo.findByEmailOrUsername(username, username);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).build();
        }
        Usuario usuario = usuarioOpt.get();

        // Ahora usa el método de tu CitaService
        List<CitaConDetalles> citas = citaService.obtenerCitasPorUsuarioId(usuario.getId_usuario());
        return ResponseEntity.ok(citas);
    }

}