/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dao.SalaDAO;
import br.edu.ifms.cinema.dao.SessaoDAO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SalaRequestDTO;
import br.edu.ifms.cinema.dto.SalaResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.mapper.FilmeMap;
import br.edu.ifms.cinema.mapper.SalaMap;
import br.edu.ifms.cinema.mapper.SessaoMap;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sala;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author rhafa
 */
public class FilmeController {
    private final FilmeDAO filmeDAO;
    private final SalaDAO salaDAO;
    private final SessaoDAO sessaoDAO;
    
    public FilmeController() {
        filmeDAO = new FilmeDAO();
        salaDAO = new SalaDAO();
        sessaoDAO = new SessaoDAO();
    }

// FILME
    public FilmeResponseDTO addFilme(FilmeRequestDTO dto) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        try {
            Filme filme = FilmeMap.toFilme(dto);
            if (filmeDAO.add(filme)) {
                response = FilmeMap.fromFilme(filme);
                response.setStatus(true);
                response.setMessage("Filme cadastrado com sucesso!");
            } else {
                response.setStatus(false);
                response.setMessage("Erro ao inserir filme no banco.");
            }
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage("Erro: " + e.getMessage());
        }
        return response;
    }

// SALA
    public SalaResponseDTO addSala(SalaRequestDTO dto) {
        SalaResponseDTO response = new SalaResponseDTO();
        try {
            Sala sala = SalaMap.toSala(dto);
            if (salaDAO.add(sala)) {
                response = SalaMap.fromSala(sala);
                response.setStatus(true);
                response.setMessage("Sala cadastrada com sucesso!");
            } else {
                response.setStatus(false);
                response.setMessage("Erro ao inserir sala.");
            }
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage("Erro: " + e.getMessage());
        }
        return response;
    }

// SESSÃO
    public SessaoResponseDTO addSessao(SessaoRequestDTO dto, Long idFilme, Long idSala) {
        SessaoResponseDTO response = new SessaoResponseDTO();
        try {
            Filme filme = filmeDAO.getById(idFilme);
            Sala sala = salaDAO.getById(idSala);

            if (filme != null && sala != null) {
                Sessao sessao = new Sessao();
                sessao.setHorario(dto.getHorario());
                sessao.setFilme(filme);
                sessao.setSala(sala);

                if (sessaoDAO.add(sessao)) {
                    FilmeResponseDTO filmeResp = FilmeMap.fromFilme(filme);
                    response = SessaoMap.fromSessao(sessao, filmeResp);
                    response.setStatus(true);
                    response.setMessage("Sessão criada com sucesso!");
                } else {
                    response.setStatus(false);
                    response.setMessage("Erro ao salvar sessão.");
                }
            } else {
                response.setStatus(false);
                response.setMessage("Filme ou Sala não encontrados (IDs inválidos).");
            }
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage("Erro: " + e.getMessage());
        }
        return response;
    }
    
// FORMATAÇÃO DO RELATÓRIO
    public String listarDadosFormatados() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DO SISTEMA (DADOS FRESCOS) ===\n\n");
        
        for (Filme f : (java.util.List<Filme>) filmeDAO.getAll()) {
            sb.append("FILME: ").append(f.getTitulo()).append(" (").append(f.getGenero()).append(")\n");
            
            if (f.getSessoes().isEmpty()) {
                sb.append("   [Nenhuma sessão cadastrada]\n");
            } else {
                for (Sessao s : f.getSessoes()) {
                    sb.append("   ├── SESSÃO: ").append(s.getHorario())
                      .append(" | Sala: ").append(s.getSala() != null ? s.getSala().getNome() : "N/A")
                      .append(" (ID: ").append(s.getId()).append(")\n");
                      
                    if(s.getIngressos() != null && !s.getIngressos().isEmpty()){
                         for(var ing : s.getIngressos()){
                             sb.append("   │      └── INGRESSO: ").append(ing.getCodigo())
                               .append(" | Cliente: ").append(ing.getCliente().getNome()).append("\n");
                         }
                    } else {
                        sb.append("   │      [Sem ingressos vendidos]\n");
                    }
                }
            }
            sb.append("--------------------------------------------------\n");
        }
        return sb.toString();
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