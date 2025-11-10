/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifms.cinema;

import br.edu.ifms.cinema.util.EM;
import br.edu.ifms.cinema.util.EMF;
import javax.persistence.EntityManager;

/**
 *
 * @author rhafa
 */
public class Cinema {

    public static void main(String[] args) {
        try {
            EntityManager em = EM.create();
            System.out.println("Conexão com o banco estabelecida com sucesso!");
            em.close();
            EMF.close();
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
