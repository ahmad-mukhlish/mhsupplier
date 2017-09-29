/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import frame.MainFrame ;
import javax.swing.JFrame;

/**
 *
 * @author GOODWARE1
 */
public class MHSupplier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           MainFrame app = new MainFrame() ;
           app.setVisible(true);
           app.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    
}
