/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author Estudante
 */
public class SessaoMap {

    // Mapeia um objeto SessaoRequestDTO para um objeto Sessao
    public static Sessao toSessao(SessaoRequestDTO dto, Filme filme) {
        Sessao sessao = new Sessao();
        sessao.setId(dto.getId());
        sessao.setHorario(dto.getHorario());
        sessao.setFilme(filme);
        return sessao;
    }

    // Mapeia um objeto SessaoRequestDTO a partir de um objeto Sessao, ou seja, mapeia um objeto Sessao para um objeto SessaoResponseDTO
    public static SessaoResponseDTO fromSessao(Sessao sessao, FilmeResponseDTO filme) {
        SessaoResponseDTO response = new SessaoResponseDTO();
        response.setId(sessao.getId());
        response.setHorario(sessao.getHorario());
        response.setFilme(filme);
        return response;
    }
}
