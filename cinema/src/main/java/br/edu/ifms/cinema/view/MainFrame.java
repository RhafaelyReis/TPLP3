package br.edu.ifms.cinema.view;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        configurarJanela();
        add(criarTitulo(), BorderLayout.NORTH);
        add(criarPainelBotoes(), BorderLayout.CENTER);
    }

// Configs gerais
    private void configurarJanela() {
        setTitle("Sistema de Gerenciamento do Cinema");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private JLabel criarTitulo() {
        JLabel lbl = new JLabel("Bem-vindo(a)", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        lbl.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        return lbl;
    }

    private JPanel criarPainelBotoes() {
        JPanel painel = new JPanel(new GridLayout(2, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        painel.add(botao("Gerenciar Registros", this::abrirSessaoView));
        painel.add(botao("Sobre o Sistema", this::abrirInformacoesView));

        return painel;
    }

// Botão padrão
    private JButton botao(String texto, Runnable acao) {
        JButton btn = new JButton(texto);
        btn.addActionListener(e -> acao.run());
        return btn;
    }

// Métodos para abrir telas secundárias
    private void abrirSessaoView() {
        new SessaoView(this).setVisible(true);
    }

    private void abrirInformacoesView() {
        new InformacoesView(this).setVisible(true);
    }
}
