/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rhafa
 */
public class SalaResponseDTO {
    private Long id;
    private String nome;
    private Integer capacidade;
    private List<SessaoResponseDTO> sessoes = new LinkedList<>();
    private boolean status;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public List<SessaoResponseDTO> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<SessaoResponseDTO> sessoes) {
        this.sessoes = sessoes;
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
