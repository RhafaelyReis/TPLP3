/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.model.Cliente;

/**
 *
 * @author rhafa
 */
public class ClienteMap {
    public static Cliente toCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        return cliente;
    }

    public static ClienteResponseDTO fromCliente(Cliente cliente) {
        ClienteResponseDTO response = new ClienteResponseDTO();
        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setEmail(cliente.getEmail());
        response.setTelefone(cliente.getTelefone());
        return response;
    }
}
