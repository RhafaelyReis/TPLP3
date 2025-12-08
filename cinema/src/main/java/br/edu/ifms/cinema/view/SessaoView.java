package br.edu.ifms.cinema.view;

import br.edu.ifms.cinema.controller.ClienteController;
import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dto.*;
import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SessaoView extends JFrame {

    private final FilmeController filmeController;
    private final ClienteController clienteController;
    private JTextArea txtAreaLog;

    public SessaoView(JFrame parent) {
        this.filmeController = new FilmeController();
        this.clienteController = new ClienteController();

        setTitle("Gerenciamento de Cinema");
        setSize(900, 700);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(criarPainelFilme());
        mainPanel.add(criarPainelSala());
        mainPanel.add(criarPainelSessao());
        mainPanel.add(criarPainelCliente());
        mainPanel.add(criarPainelIngresso());
        mainPanel.add(criarPainelVisualizacao());
    }

// PAINEIS
    private JPanel criarPainelFilme() {
        JPanel panel = criarPainel("CADASTRAR FILME");

        JTextField txtTitulo = new JTextField(15);
        JTextField txtGenero = new JTextField(10);
        JTextField txtDuracao = new JTextField(5);
        JTextField txtClassificacao = new JTextField(5);

        panel.add(linhaCampo("Título:", txtTitulo, "Gênero:", txtGenero));
        panel.add(linhaCampo("Minutos:", txtDuracao, "Classificação:", txtClassificacao));

        JButton btnSalvar = botao("Salvar Filme", () -> {
            try {
                FilmeRequestDTO dto = new FilmeRequestDTO();
                dto.setTitulo(txtTitulo.getText());
                dto.setGenero(txtGenero.getText());
                dto.setDuracaoMinutos(Integer.parseInt(txtDuracao.getText()));
                dto.setClassificacao(txtClassificacao.getText());

                FilmeResponseDTO resp = filmeController.addFilme(dto);
                logMensagem(resp.getMessage() + " (ID: " + resp.getId() + ")");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        panel.add(btnSalvar);
        return panel;
    }

    private JPanel criarPainelSala() {
        JPanel panel = criarPainel("CADASTRAR SALA");

        JTextField txtNome = new JTextField(15);
        JTextField txtCapacidade = new JTextField(5);

        panel.add(linhaCampo("Nome da Sala:", txtNome, "Capacidade:", txtCapacidade));

        JButton btnSalvar = botao("Salvar Sala", () -> {
            try {
                SalaRequestDTO dto = new SalaRequestDTO();
                dto.setNome(txtNome.getText());
                dto.setCapacidade(Integer.parseInt(txtCapacidade.getText()));

                SalaResponseDTO resp = filmeController.addSala(dto);
                logMensagem(resp.getMessage() + " (ID: " + resp.getId() + ")");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        panel.add(btnSalvar);
        return panel;
    }

    private JPanel criarPainelSessao() {
        JPanel panel = criarPainel("CADASTRAR SESSÃO");

        JTextField txtIdFilme = new JTextField(4);
        JTextField txtIdSala = new JTextField(4);
        JTextField txtDataHora = new JTextField("2025-11-20T19:00", 12);

        panel.add(linhaCampo("ID Filme:", txtIdFilme, "ID Sala:", txtIdSala));
        panel.add(linhaCampo("Data(ISO):", txtDataHora));

        JButton btnCriar = botao("Criar Sessão", () -> {
            try {
                SessaoRequestDTO dto = new SessaoRequestDTO();
                dto.setHorario(LocalDateTime.parse(txtDataHora.getText()));

                Long idF = Long.parseLong(txtIdFilme.getText());
                Long idS = Long.parseLong(txtIdSala.getText());

                SessaoResponseDTO resp = filmeController.addSessao(dto, idF, idS);
                logMensagem(resp.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro(aaaa-mm-ddThh:mm): " + ex.getMessage());
            }
        });

        panel.add(btnCriar);
        return panel;
    }

    private JPanel criarPainelCliente() {
        JPanel panel = criarPainel("CADASTRAR CLIENTE");

        JTextField txtNome = new JTextField(15);
        JTextField txtEmail = new JTextField(10);
        JTextField txtTel = new JTextField(9);

        panel.add(linhaCampo("Nome:", txtNome, "Email:", txtEmail));
        panel.add(linhaCampo("Tel:", txtTel));

        JButton btnSalvar = botao("Salvar Cliente", () -> {
            try {
                ClienteRequestDTO dto = new ClienteRequestDTO();
                dto.setNome(txtNome.getText());
                dto.setEmail(txtEmail.getText());
                dto.setTelefone(txtTel.getText());

                ClienteResponseDTO resp = clienteController.add(dto);
                logMensagem(resp.getMessage() + " (ID: " + resp.getId() + ")");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        panel.add(btnSalvar);
        return panel;
    }

    private JPanel criarPainelIngresso() {
        JPanel panel = criarPainel("VENDER INGRESSO");

        JTextField txtIdSessao = new JTextField(4);
        JTextField txtIdCliente = new JTextField(4);
        JTextField txtValor = new JTextField("xx.xx", 6);

        panel.add(linhaCampo("ID Sessão:", txtIdSessao, "ID Cliente:", txtIdCliente));
        panel.add(linhaCampo("Valor:", txtValor));

        JButton btnVender = botao("Registrar Venda", () -> {
            try {
                IngressoRequestDTO dto = new IngressoRequestDTO();
                dto.setSessaoId(Long.parseLong(txtIdSessao.getText()));
                dto.setClienteId(Long.parseLong(txtIdCliente.getText()));
                dto.setValor(Double.parseDouble(txtValor.getText()));
                dto.setCodigo("ING-" + System.currentTimeMillis());

                IngressoResponseDTO resp = clienteController.addIngresso(dto);
                logMensagem(resp.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao vender: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        panel.add(btnVender);
        return panel;
    }

    private JPanel criarPainelVisualizacao() {
        JPanel panel = criarPainel("VISUALIZAR INFORMAÇÕES");
        panel.setLayout(new BorderLayout());

        JButton btnAtualizar = botao("Ver", () -> {
            try {
                String relatorio = filmeController.listarDadosFormatados();
                txtAreaLog.setText(relatorio);
            } catch (Exception ex) {
                txtAreaLog.setText("Erro ao gerar relatório: " + ex.getMessage());
            }
        });

        txtAreaLog = new JTextArea(10, 60);
        txtAreaLog.setEditable(false);
        txtAreaLog.setFont(new Font("Monospaced", Font.PLAIN, 12));

        panel.add(btnAtualizar, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtAreaLog), BorderLayout.CENTER);

        return panel;
    }

// COMPONENTES AUXILIARES

    private JPanel criarPainel(String titulo) {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(borda(titulo));
        return painel;
    }

    private TitledBorder borda(String titulo) {
        TitledBorder borda = BorderFactory.createTitledBorder(titulo);
        borda.setTitleFont(new Font("Arial", Font.BOLD, 14));
        borda.setTitleColor(Color.MAGENTA);
        return borda;
    }

    private JPanel linhaCampo(Object... args) {
        JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        for (Object a : args) {
            linha.add(a instanceof String ? new JLabel((String) a) : (Component) a);
        }
        return linha;
    }

    private JButton botao(String nome, Runnable acao) {
        JButton btn = new JButton(nome);
        btn.addActionListener(e -> acao.run());
        return btn;
    }

    private void logMensagem(String msg) {
        JOptionPane.showMessageDialog(this, msg);
        if (txtAreaLog != null) {
            txtAreaLog.append("> " + msg + "\n");
        }
    }
}