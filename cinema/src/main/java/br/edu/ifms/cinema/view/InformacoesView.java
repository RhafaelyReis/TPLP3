/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rhafa
 */
public class InformacoesView extends JFrame{
    
    public InformacoesView(JFrame parent) {
        setTitle("Ficha Técnica");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

// Painel geral
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        panelContent.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

// Cabeçalho
        panelContent.add(labelTitulo("Gerenciamento de Cinema"));
        
        panelContent.add(espaco(5));
        
        panelContent.add(labelItalico("Versão 1.0.0 - 2025"));
        
        panelContent.add(espaco(20));

// Instituição/curso/disciplina
        panelContent.add(labelNegrito("INSTITUIÇÃO"));
        panelContent.add(labelNormal("Instituto Federal de Mato Grosso do Sul (IFMS)"));
        panelContent.add(labelNormal("Curso: Tecnologia em Sistemas para Internet"));
        panelContent.add(labelNormal("Disciplina: Linguagem de Programação III"));

        panelContent.add(espaco(20));

// Sobre o projeto
        panelContent.add(labelNegrito("SOBRE O PROJETO"));
        panelContent.add(labelNormal("Sistema de gerenciamento de sessões, "));
        panelContent.add(labelNormal("controle de salas e venda de ingressos "));
        panelContent.add(labelNormal("de cinema."));
        
        panelContent.add(espaco(20));

// Tecnologias
        panelContent.add(labelNegrito("TECNOLOGIAS EMPREGADAS"));
        panelContent.add(labelNormal("• Java"));
        panelContent.add(labelNormal("• Java Swing (Interface Gráfica)"));
        panelContent.add(labelNormal("• Java Persistence API"));
        panelContent.add(labelNormal("• MySQL"));

        panelContent.add(espaco(20));
        
        panelContent.add(labelItalico("Desenvolvido por: Rhafaely Reis"));

        add(panelContent, BorderLayout.CENTER);

    }

// Métodos auxiliares
    private JLabel labelTitulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 26));
        label.setForeground(Color.MAGENTA);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JLabel labelNegrito(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JLabel labelNormal(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    private JLabel labelItalico(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        label.setForeground(Color.DARK_GRAY);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private Component espaco(int altura) {
        return javax.swing.Box.createVerticalStrut(altura);
    }
}
    