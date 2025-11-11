/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rhafa
 */
public class EntityManagerFactorySingleton {
    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT_NAME = "UP";

    private EntityManagerFactorySingleton() {
        // construtor privado → impede instanciamento externo
    }

    public static EntityManagerFactory getEMF() {
        if (emf == null) {
            synchronized(EntityManagerFactory.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                }
            }
        }
        return emf;
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
