/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dao;

import br.edu.ifms.cinema.model.Ingresso;
import br.edu.ifms.cinema.util.EntityManagerObjectFactory;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author rhafa
 */
public class IngressoDAO implements GenericDAO<Ingresso>{
    private EntityManager em;

    @Override
    public boolean add(Ingresso entity) {
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
    public Ingresso update(Ingresso entity) {
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
            throw new RuntimeException("Falha ao alterar os dados do ingresso");
        } finally {
            em.close();
        }
    }

    @Override
    public boolean remove(Ingresso entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            if(em.find(Ingresso.class, entity.getId()) == null)
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
    public Ingresso getById(long id) {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT f FROM Ingresso f WHERE f.id = :id");
            query.setParameter("id", id);
            return (Ingresso) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Ingresso> getAll() {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT f FROM Ingresso f");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new LinkedList<>();
        } finally {
            em.close();
        }
    }
    
}
