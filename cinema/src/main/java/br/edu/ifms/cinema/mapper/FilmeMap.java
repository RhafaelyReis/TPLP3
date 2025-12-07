/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.model.Filme;

/**
 *
 * @author rhafa
 */
public class FilmeMap {

    public static Filme toFilme(FilmeRequestDTO dto) {
        Filme filme = new Filme();
        filme.setId(dto.getId());
        filme.setTitulo(dto.getTitulo());
        filme.setGenero(dto.getGenero());
        filme.setClassificacao(dto.getClassificacao());
        filme.setDuracaoMinutos(dto.getDuracaoMinutos());
        return filme;
    }

    public static FilmeResponseDTO fromFilme(Filme filme) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        response.setId(filme.getId());
        response.setTitulo(filme.getTitulo());
        response.setGenero(filme.getGenero());
        response.setDuracaoMinutos(filme.getDuracaoMinutos());
        response.setClassificacao(filme.getClassificacao());
        return response;
    }
}
