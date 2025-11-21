/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rhafa
 */
@Entity
@Table(name = "salas")
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer capacidade;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assento> assentos;

//    @OneToMany(mappedBy = "sala")
//    private List<Sessao> sessoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

//    public List<Assento> getAssentos() {
//        return assentos;
//    }
//
//    public void setAssentos(List<Assento> assentos) {
//        this.assentos = assentos;
//    }
//
//    public List<Sessao> getSessoes() {
//        return sessoes;
//    }
//
//    public void setSessoes(List<Sessao> sessoes) {
//        this.sessoes = sessoes;
//    }
//
//    @Override
//    public String toString() {
//        return "Sala[ id=" + id + ", nome=" + nome + " ]";
//    }
}