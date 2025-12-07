/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.IngressoRequestDTO;
import br.edu.ifms.cinema.dto.IngressoResponseDTO;
import br.edu.ifms.cinema.model.Assento;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Ingresso;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author rhafa
 */
public class IngressoMap {
    public static Ingresso toIngresso(IngressoRequestDTO dto, Sessao sessao, Cliente cliente, Assento assento) {
        Ingresso ing = new Ingresso();
        ing.setId(dto.getId());
        ing.setCodigo(dto.getCodigo());
        ing.setValor(dto.getValor());
        ing.setSessao(sessao);
        ing.setCliente(cliente);
        ing.setAssento(assento);
        return ing;
    }

    public static IngressoResponseDTO fromIngresso(Ingresso ing) {
        IngressoResponseDTO dto = new IngressoResponseDTO();
        dto.setId(ing.getId());
        dto.setCodigo(ing.getCodigo());
        dto.setValor(ing.getValor());

        if (ing.getSessao() != null)
            dto.setSessaoInfo("Sala: " + ing.getSessao().getSala().getNome());

        if (ing.getCliente() != null)
            dto.setClienteNome(ing.getCliente().getNome());

        if (ing.getAssento() != null)
            dto.setAssentoNumero(ing.getAssento().getNumero());

        return dto;
    }
}
