/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rhafa
 */
@Entity
@Table(name = "sessoes")
public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime horario;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

//    @ManyToOne
//    @JoinColumn(name = "sala_id")
//    private Sala sala;
//
//    @OneToMany(mappedBy = "sessao")
//    private List<Ingresso> ingressos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

//    public Sala getSala() {
//        return sala;
//    }
//
//    public void setSala(Sala sala) {
//        this.sala = sala;
//    }
//
//    public List<Ingresso> getIngressos() {
//        return ingressos;
//    }
//
//    public void setIngressos(List<Ingresso> ingressos) {
//        this.ingressos = ingressos;
//    }

    @Override
    public String toString() {
        return "Sessao[ id=" + id + ", horario=" + horario + " ]";
    }
}
