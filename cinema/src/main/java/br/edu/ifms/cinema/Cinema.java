/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifms.cinema;

import br.edu.ifms.cinema.view.MainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rhafa
 */
public class Cinema {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Tenta aplicar o visual do sistema operacional
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}