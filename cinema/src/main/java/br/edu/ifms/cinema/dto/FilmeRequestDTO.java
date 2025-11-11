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
public class FilmeRequestDTO {
    private Long id;
    private String titulo;
    private String genero;
    private Integer duracaoMinutos;
    private String classificacao;
    private List<SessaoRequestDTO> sessoes = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public List<SessaoRequestDTO> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<SessaoRequestDTO> sessoes) {
        this.sessoes = sessoes;
    }
    
    
}
