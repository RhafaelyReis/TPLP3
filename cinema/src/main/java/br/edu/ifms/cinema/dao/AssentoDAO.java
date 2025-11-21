/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dao;

import br.edu.ifms.cinema.model.Assento;
import br.edu.ifms.cinema.util.EntityManagerObjectFactory;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author rhafa
 */
public class AssentoDAO implements GenericDAO<Assento>{
    private EntityManager em;

    @Override
    public boolean add(Assento entity) {
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
    public Assento update(Assento entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            return entity;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean remove(Assento entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            if(em.find(Assento.class, entity.getId()) == null)
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
    public Assento getById(long id) {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT f FROM Assento f WHERE f.id = :id");
            query.setParameter("id", id);
            return (Assento) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Assento> getAll() {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT f FROM Assento f");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new LinkedList<>();
        } finally {
            em.close();
        }
    }
    
}
