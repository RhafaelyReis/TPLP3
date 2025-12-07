/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.mapper.FilmeMap;
import br.edu.ifms.cinema.mapper.SessaoMap;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author rhafa
 */
public class FilmeController {

    private static GenericDAO filmeDAO;

    public FilmeController() {
        filmeDAO = new FilmeDAO();

    }

    public FilmeResponseDTO add(FilmeRequestDTO dto) {
        FilmeResponseDTO response = null;
        if (dto != null) {
            // implementar série de validações

            if (dto.getId() != null) {
                response = new FilmeResponseDTO();
                response.setStatus(false);
                response.setMessage("Transação inválida.");
                return response;
            }

            Filme filme = FilmeMap.toFilme(dto);
            for (SessaoRequestDTO sessaoDTO : dto.getSessoes()) {
                Sessao sessao = SessaoMap.toSessao(sessaoDTO, filme);
                filme.getSessoes().add(sessao);
            }
            boolean retorno = filmeDAO.add(filme);

            response = FilmeMap.fromFilme(filme);
            for (Sessao sessao : filme.getSessoes()) {
                SessaoResponseDTO sessaoDTO = SessaoMap.fromSessao(sessao, response);
                response.getSessoes().add(sessaoDTO);

            }

            if (retorno) {
                response.setStatus(true);
                response.setMessage("Filme cadastrado");
            } else {
                response.setStatus(false);
                response.setMessage("Problema ao cadastrar o filme");
            }
            //mapeamento de filme para FilmeResponseDTO e SessaoResponseDTO
        }
        return response;
    }

    public FilmeResponseDTO update(FilmeRequestDTO dto) {
        FilmeResponseDTO response = null;
        if (dto != null) {
            try {
                if (dto.getId() == null) {
                    response = new FilmeResponseDTO();
                    response.setStatus(false);
                    response.setMessage("Transação inválida.");
                    return response;
                }

                Filme filme = FilmeMap.toFilme(dto);
                for (SessaoRequestDTO sessaoDTO : dto.getSessoes()) {
                    Sessao sessao = SessaoMap.toSessao(sessaoDTO, filme);
                    filme.getSessoes().add(sessao);
                }

                filme = (Filme) filmeDAO.update(filme);

                response = FilmeMap.fromFilme(filme);
                for (Sessao sessao : filme.getSessoes()) {
                    SessaoResponseDTO sessaoDTO = SessaoMap.fromSessao(sessao, response);
                    response.getSessoes().add(sessaoDTO);
                }

                response.setStatus(true);
                response.setMessage("Filme Alterado");
            } catch (RuntimeException e) {
                response.setStatus(false);
                response.setMessage(e.getMessage());
            }
        }
        return response;
    }
}
