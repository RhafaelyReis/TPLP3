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
public class EMF {
    private static EntityManagerFactory emf;

    private EMF() {
        // construtor privado → impede instanciamento externo
    }

    public static EntityManagerFactory get() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("UP");
        }
        return emf;
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
