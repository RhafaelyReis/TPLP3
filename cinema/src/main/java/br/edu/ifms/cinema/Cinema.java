/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifms.cinema;

import br.edu.ifms.cinema.controller.ClienteController;
import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author rhafa
 */
public class Cinema {

    public static void main(String[] args) {
        
        System.out.println("*********************************************************************** Teste 1: Popula banco");
        try {
            Filme f1 = new Filme();
            Filme f2 = new Filme();
            Filme f3 = new Filme();
            
            f1.setTitulo("Quarteto Fantástico");
            f1.setGenero("Ação");
            f1.setDuracaoMinutos(140);
            f1.setClassificacao("14");
            
            f2.setTitulo("Divertidamente");
            f2.setGenero("Animação");
            f2.setDuracaoMinutos(125);
            f2.setClassificacao("Livre");
            
            f3.setTitulo("O Silêncio dos inocentes");
            f3.setGenero("Suspense");
            f3.setDuracaoMinutos(113);
            f3.setClassificacao("16");
            
            Sessao s1 = new Sessao();
            Sessao s2 = new Sessao();
            Sessao s3 = new Sessao();
            Sessao s4 = new Sessao();

            s1.setHorario(LocalDateTime.of(2025, 11, 11, 14, 00));
            s1.setFilme(f2);
            
            s2.setHorario(LocalDateTime.of(2025, 11, 11, 19, 00));
            s2.setFilme(f3);
            
            s3.setHorario(LocalDateTime.of(2025, 11, 11, 22, 00));
            s3.setFilme(f3);
            
            s4.setHorario(LocalDateTime.of(2025, 11, 12, 16, 30));
            s4.setFilme(f1);
            
            f1.getSessoes().add(s4);
            f2.getSessoes().add(s1);
            f3.getSessoes().add(s2);
            f3.getSessoes().add(s3);

            FilmeDAO fdao = new FilmeDAO();
            fdao.add(f1);
            fdao.add(f2);
            fdao.add(f3);
            System.out.println(">> Dados iniciais inseridos (Filmes e Sessões).");
        } catch (Exception e) {
            System.out.println(">> Erro ao popular (talvez dados já existam): " + e.getMessage());
        }

        System.out.println("\n*********************************************************************** Teste 2: Adiciona filme");
        FilmeRequestDTO request = new FilmeRequestDTO();
        request.setTitulo("Matrix");
        request.setGenero("Sci-fi");
        request.setDuracaoMinutos(202);
        request.setClassificacao("Livre");

        SessaoRequestDTO sessao = new SessaoRequestDTO();
        sessao.setFilme(request);
        sessao.setHorario(LocalDateTime.of(2025, 11, 18, 15, 30));
        request.getSessoes().add(sessao);

        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
        sessao2.setFilme(request);
        sessao2.setHorario(LocalDateTime.of(2025, 11, 18, 18, 00));
        request.getSessoes().add(sessao2);

        FilmeController controle = new FilmeController();

        // mostrar os dados de resposta
        FilmeResponseDTO response = controle.add(request);
        if (response.isStatus()) {
            JOptionPane.showMessageDialog(
                    null,
                    response.getMessage(),
                    "Filme Cadastrado com sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.out.println("Filme Cadastrado:");
            System.out.println("ID: " + response.getId());
            System.out.println("TÍTULO: " + response.getTitulo());
            System.out.println("GÊNERO: " + response.getGenero());
            System.out.println("DURAÇÃO(min): " + response.getDuracaoMinutos());
            System.out.println("CLASSIFICAÇÃO: " + response.getClassificacao());
            System.out.println("Sessões:");
            for (SessaoResponseDTO sessaoResp : response.getSessoes()) {
                System.out.println("  ID: " + sessaoResp.getId());
                System.out.println("  HORÁRIO: " + sessaoResp.getHorario());
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    response.getMessage(),
                    "Falha no cadastro de Filme",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        System.out.println("\n*********************************************************************** Teste 3: Update Filme");
        FilmeRequestDTO requestUpdate = new FilmeRequestDTO();
        requestUpdate.setId(4L); 
        requestUpdate.setTitulo("Matrix Reloaded");
        requestUpdate.setGenero("Ficção Científica"); // Mudança
        requestUpdate.setDuracaoMinutos(202);
        requestUpdate.setClassificacao("14"); // Mudança

        // Adicionando uma nova sessão no update
        SessaoRequestDTO sessaoUpdate = new SessaoRequestDTO();
        sessaoUpdate.setFilme(requestUpdate);
        sessaoUpdate.setHorario(LocalDateTime.of(2025, 11, 20, 21, 00));
        requestUpdate.getSessoes().add(sessaoUpdate);

        FilmeResponseDTO responseUpdate = controle.update(requestUpdate);
        
        if (responseUpdate != null && responseUpdate.isStatus()) {
            JOptionPane.showMessageDialog(
                    null,
                    responseUpdate.getMessage(),
                    "Filme Atualizado com sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.out.println("Filme Atualizado:");
            System.out.println("ID: " + responseUpdate.getId());
            System.out.println("NOVO TÍTULO: " + responseUpdate.getTitulo());
            System.out.println("NOVO GÊNERO: " + responseUpdate.getGenero());
        } else {
            System.out.println("Aviso Teste 3: " + (responseUpdate != null ? responseUpdate.getMessage() : "Erro desconhecido"));
        }

        System.out.println("\n*********************************************************************** Teste 4: Adiciona cliente");
        
        // 1. Cria o DTO de requisição
        ClienteRequestDTO clienteReq = new ClienteRequestDTO();
        clienteReq.setNome("João");
        clienteReq.setEmail("joao@gmail.com");
        clienteReq.setTelefone("(67)99999-8888");

        // 2. Instancia o controller
        ClienteController clienteCtrl = new ClienteController();

        // 3. Chama o método add
        ClienteResponseDTO clienteResp = clienteCtrl.add(clienteReq);

        // 4. Verifica e exibe a resposta
        if (clienteResp.isStatus()) {
            JOptionPane.showMessageDialog(
                    null,
                    clienteResp.getMessage(),
                    "Cliente Cadastrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.out.println("Cliente Cadastrado:"); // Mostra os dados
            System.out.println("ID: " + clienteResp.getId());
            System.out.println("NOME: " + clienteResp.getNome());
            System.out.println("EMAIL: " + clienteResp.getEmail());
            System.out.println("TELEFONE: " + clienteResp.getTelefone());
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    clienteResp.getMessage(),
                    "Erro ao cadastrar Cliente",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Erro Cliente: " + clienteResp.getMessage());
        }

        System.out.println("\n*********************************************************************** FIM DOS TESTES");
    }
}