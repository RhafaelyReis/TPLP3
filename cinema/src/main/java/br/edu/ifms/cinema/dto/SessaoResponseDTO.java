/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dto;

import java.time.LocalDateTime;

/**
 *
 * @author Estudante
 */
public class SessaoResponseDTO {
    private Long id;
    private LocalDateTime horario;
    private FilmeResponseDTO filme;
    private boolean status;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public FilmeResponseDTO getFilme() {
        return filme;
    }

    public void setFilme(FilmeResponseDTO filme) {
        this.filme = filme;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
