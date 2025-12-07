/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.ClienteDAO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.mapper.ClienteMap;
import br.edu.ifms.cinema.model.Cliente;

/**
 *
 * @author rhafa
 */
public class ClienteController {
    private static GenericDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public ClienteResponseDTO add(ClienteRequestDTO dto) {
        ClienteResponseDTO response = new ClienteResponseDTO();

        if (dto.getId() != null) {
            response.setStatus(false);
            response.setMessage("Transação inválida.");
            return response;
        }

        Cliente cliente = ClienteMap.toCliente(dto);
        boolean retorno = clienteDAO.add(cliente);

        response = ClienteMap.fromCliente(cliente);
        if (retorno) {
            response.setStatus(true);
            response.setMessage("Cliente cadastrado com sucesso.");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao cadastrar cliente.");
        }

        return response;
    }

    public ClienteResponseDTO update(ClienteRequestDTO dto) {
        ClienteResponseDTO response = new ClienteResponseDTO();

        if (dto.getId() == null) {
            response.setStatus(false);
            response.setMessage("Transação inválida.");
            return response;
        }

        try {
            Cliente cliente = ClienteMap.toCliente(dto);
            cliente = (Cliente) clienteDAO.update(cliente);

            response = ClienteMap.fromCliente(cliente);
            response.setStatus(true);
            response.setMessage("Cliente atualizado.");
        } catch (RuntimeException e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
