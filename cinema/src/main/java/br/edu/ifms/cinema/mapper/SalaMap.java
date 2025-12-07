/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.SalaRequestDTO;
import br.edu.ifms.cinema.dto.SalaResponseDTO;
import br.edu.ifms.cinema.model.Sala;

/**
 *
 * @author rhafa
 */
public class SalaMap {
    public static Sala toSala(SalaRequestDTO dto) {
        Sala sala = new Sala();
        sala.setId(dto.getId());
        sala.setNome(dto.getNome());
        sala.setCapacidade(dto.getCapacidade());
        return sala;
    }

    public static SalaResponseDTO fromSala(Sala sala) {
        SalaResponseDTO response = new SalaResponseDTO();
        response.setId(sala.getId());
        response.setNome(sala.getNome());
        response.setCapacidade(sala.getCapacidade());
        return response;
    }
}
