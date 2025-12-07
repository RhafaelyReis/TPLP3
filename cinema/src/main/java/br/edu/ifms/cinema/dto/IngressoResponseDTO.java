/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dto;

/**
 *
 * @author rhafa
 */
public class IngressoResponseDTO {
    private Long id;
    private String codigo;
    private Double valor;
    private String sessaoInfo;
    private String clienteNome;
    private String assentoNumero;
    private boolean status;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getSessaoInfo() {
        return sessaoInfo;
    }

    public void setSessaoInfo(String sessaoInfo) {
        this.sessaoInfo = sessaoInfo;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getAssentoNumero() {
        return assentoNumero;
    }

    public void setAssentoNumero(String assentoNumero) {
        this.assentoNumero = assentoNumero;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
