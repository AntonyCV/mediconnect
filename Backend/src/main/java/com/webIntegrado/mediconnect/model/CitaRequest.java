package com.webIntegrado.mediconnect.model;

import java.time.LocalDateTime;

public class CitaRequest {
    private Long pacienteId;
    private Long medicoId;
    private Long sedeId;
    private LocalDateTime fechaHora;
    private String motivo;


// getter y setter


    public Long getPacienteId() {return pacienteId;}
    public void setPacienteId(Long pacienteId) {this.pacienteId = pacienteId;}

    public Long getMedicoId() {return medicoId;}
    public void setMedicoId(Long medicoId) {this.medicoId = medicoId;}

    public LocalDateTime getFechaHora() {return fechaHora;}
    public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}

    public String getMotivo() {return motivo;}
    public void setMotivo(String motivo) {this.motivo = motivo;}

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId;}
}
