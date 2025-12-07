/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dao;

import br.edu.ifms.cinema.model.CartaoFidelidade;
import br.edu.ifms.cinema.util.EntityManagerObjectFactory;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author rhafa
 */
public class CartaoFidelidadeDAO implements GenericDAO<CartaoFidelidade>{
    private EntityManager em;

    @Override
    public boolean add(CartaoFidelidade entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

    }

    @Override
    public CartaoFidelidade update(CartaoFidelidade entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
               em.getTransaction().rollback(); 
            }
            System.err.println(e.getMessage());
            throw new RuntimeException("Falha ao alterar os dados do cartão");
        } finally {
            em.close();
        }
    }

    @Override
    public boolean remove(CartaoFidelidade entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            if(em.find(CartaoFidelidade.class, entity.getId()) == null)
                em. merge(em);
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public CartaoFidelidade getById(long id) {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT f FROM CartaoFidelidade f WHERE f.id = :id");
            query.setParameter("id", id);
            return (CartaoFidelidade) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<CartaoFidelidade> getAll() {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT f FROM CartaoFidelidade f");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new LinkedList<>();
        } finally {
            em.close();
        }
    }
    
}