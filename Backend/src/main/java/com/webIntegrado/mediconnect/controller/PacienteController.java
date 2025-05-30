package com.webIntegrado.mediconnect.controller;

import com.webIntegrado.mediconnect.model.Paciente;
import com.webIntegrado.mediconnect.model.Usuario;
import com.webIntegrado.mediconnect.repository.PacienteRepository;
import com.webIntegrado.mediconnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/mi-perfil")
    public ResponseEntity<?> obtenerDatosPacienteAutenticado(Authentication authentication) {
        String username = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmailOrUsername(username, username)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        Paciente paciente = pacienteRepository.findByUsuarioId(usuario.getId_usuario())
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        return ResponseEntity.ok(Map.of(
                "nombres", paciente.getNombres(),
                "apellidos", paciente.getApellidos()
        ));
    }
}
