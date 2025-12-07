/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dao.ClienteDAO;
import br.edu.ifms.cinema.dto.CartaoFidelidadeRequestDTO;
import br.edu.ifms.cinema.dto.CartaoFidelidadeResponseDTO;
import br.edu.ifms.cinema.model.CartaoFidelidade;
import br.edu.ifms.cinema.model.Cliente;

/**
 *
 * @author rhafa
 */
public class CartaoFidelidadeMap {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public CartaoFidelidade toEntity(CartaoFidelidadeRequestDTO dto) {
        CartaoFidelidade cartao = new CartaoFidelidade();
        cartao.setPontos(dto.getPontos());
        cartao.setNivel(dto.getNivel());

        if(dto.getClienteId() != null){
            Cliente cliente = clienteDAO.getById(dto.getClienteId());
            cartao.setCliente(cliente);
        }

        return cartao;
    }

    public CartaoFidelidadeResponseDTO toDTO(CartaoFidelidade cartao) {
        CartaoFidelidadeResponseDTO dto = new CartaoFidelidadeResponseDTO();
        dto.setId(cartao.getId());
        dto.setPontos(cartao.getPontos());
        dto.setNivel(cartao.getNivel());

        if(cartao.getCliente() != null){
            dto.setClienteNome(cartao.getCliente().getNome());
        }

        return dto;
    }
}
