/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifms.cinema;

import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import br.edu.ifms.cinema.util.EntityManagerObjectFactory;
import br.edu.ifms.cinema.util.EntityManagerFactorySingleton;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author rhafa
 */
public class Cinema {

    public static void main(String[] args) {
//////////////////////////////////////////////////////////////////////////////// Teste 1
//        Filme f1 = new Filme();
//        Filme f2 = new Filme();
//        Filme f3 = new Filme();
//        
//        f1.setTitulo("Quarteto Fantástico");
//        f1.setGenero("Ação");
//        f1.setDuracaoMinutos(140);
//        f1.setClassificacao("14");
//        
//        f2.setTitulo("Divertidamente");
//        f2.setGenero("Animação");
//        f2.setDuracaoMinutos(125);
//        f2.setClassificacao("Livre");
//        
//        f3.setTitulo("O Silêncio dos inocentes");
//        f3.setGenero("Suspense");
//        f3.setDuracaoMinutos(113);
//        f3.setClassificacao("16");
//        
//        Sessao s1 = new Sessao();
//        Sessao s2 = new Sessao();
//        Sessao s3 = new Sessao();
//        Sessao s4 = new Sessao();
//
//        s1.setHorario(LocalDateTime.of(2025, 11, 11, 14, 00));
//        s1.setFilme(f2);
//        
//        s2.setHorario(LocalDateTime.of(2025, 11, 11, 19, 00));
//        s2.setFilme(f3);
//        
//        s3.setHorario(LocalDateTime.of(2025, 11, 11, 22, 00));
//        s3.setFilme(f3);
//        
//        s4.setHorario(LocalDateTime.of(2025, 11, 12, 16, 30));
//        s4.setFilme(f1);
//        
//        f1.getSessoes().add(s4);
//        f2.getSessoes().add(s1);
//        f3.getSessoes().add(s2);
//        f3.getSessoes().add(s3);
//
//        FilmeDAO fdao = new FilmeDAO();
//        fdao.add(f1);
//        fdao.add(f2);
//        fdao.add(f3);
//////////////////////////////////////////////////////////////////////////////// Teste 2
//        FilmeRequestDTO request = new FilmeRequestDTO();
//        request.setTitulo("Matrix");
//        request.setGenero("Sci-fi");
//        request.setDuracaoMinutos(202);
//        request.setClassificacao("Livre");
//
//        SessaoRequestDTO sessao = new SessaoRequestDTO();
//        sessao.setFilme(request);
//        sessao.setHorario(LocalDateTime.of(2025, 11, 18, 15, 30));
//        request.getSessoes().add(sessao);
//
//        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
//        sessao2.setFilme(request);
//        sessao2.setHorario(LocalDateTime.of(2025, 11, 18, 18, 00));
//        request.getSessoes().add(sessao2);
//
//        FilmeController controle = new FilmeController();
//
//        // mostrar os dados de resposta
//        FilmeResponseDTO response = controle.add(request);
//        if (response.isStatus()) {
//            JOptionPane.showMessageDialog(
//                    null,
//                    response.getMessage(),
//                    "Cadastrado com sucesso",
//                    JOptionPane.INFORMATION_MESSAGE
//            );
//            System.out.println("Filme");
//            System.out.println("ID: " + response.getId());
//            System.out.println("TÍTULO: " + response.getTitulo());
//            System.out.println("GÊNERO: " + response.getGenero());
//            System.out.println("DURAÇÃO(min): " + response.getDuracaoMinutos());
//            System.out.println("CLASSIFICAÇÃO: " + response.getClassificacao());
//            System.out.println("Sessões:");
//            for (SessaoResponseDTO sessaoResp : response.getSessoes()) {
//                System.out.println("ID: " + sessaoResp.getId());
//                System.out.println("HORÁRIO: " + sessaoResp.getHorario());
//                System.out.println("-----------------------------------");
//            }
//        } else {
//            JOptionPane.showMessageDialog(
//                    null,
//                    response.getMessage(),
//                    "Falha no cadastro",
//                    JOptionPane.ERROR_MESSAGE
//            );
//        }
//////////////////////////////////////////////////////////////////////////////// Teste 3
        FilmeRequestDTO request = new FilmeRequestDTO();
        request.setId(1L);
        request.setTitulo("Matrix 2");
        request.setGenero("Ficção");
        request.setDuracaoMinutos(202);
        request.setClassificacao("Livre");

//        SessaoRequestDTO sessao = new SessaoRequestDTO();
//        sessao.setFilme(request);
//        sessao.setHorario(LocalDateTime.of(2025, 11, 18, 15, 30));
//        request.getSessoes().add(sessao);
//
//        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
//        sessao2.setFilme(request);
//        sessao2.setHorario(LocalDateTime.of(2025, 11, 18, 18, 00));
//        request.getSessoes().add(sessao2);

        FilmeController controle = new FilmeController();

        // mostrar os dados de resposta
        FilmeResponseDTO response = controle.update(request);
        if (response.isStatus()) {
            JOptionPane.showMessageDialog(
                    null,
                    response.getMessage(),
                    "Cadastrado com sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.out.println("Filme");
            System.out.println("ID: " + response.getId());
            System.out.println("TÍTULO: " + response.getTitulo());
            System.out.println("GÊNERO: " + response.getGenero());
            System.out.println("DURAÇÃO(min): " + response.getDuracaoMinutos());
            System.out.println("CLASSIFICAÇÃO: " + response.getClassificacao());
            System.out.println("Sessões:");
            for (SessaoResponseDTO sessaoResp : response.getSessoes()) {
                System.out.println("ID: " + sessaoResp.getId());
                System.out.println("HORÁRIO: " + sessaoResp.getHorario());
                System.out.println("-----------------------------------");
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    response.getMessage(),
                    "Falha no cadastro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
