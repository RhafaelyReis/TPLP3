/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.util;

import javax.persistence.EntityManager;

/**
 *
 * @author rhafa
 */
public class EM {
    public static EntityManager create() {
        return EMF.get().createEntityManager();
    }
}
