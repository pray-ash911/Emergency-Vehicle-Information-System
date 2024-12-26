/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.EmergencyVehicleIS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;


/**
 *
 * @author hp
 */
public class LoadingScreen extends javax.swing.JFrame {
    private Timer timer; // Timer to update progress bar
     private int progress = 0; // Progress value for the loading bar
    /**
     * Creates new form LoadingScreen
     */
    public LoadingScreen() {
        initComponents();
        this.setTitle("Loading Screen");
         this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startLoading();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLoadingScreen = new javax.swing.JPanel();
        jProgressBarloading = new javax.swing.JProgressBar();
        lblLoadingScreen = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlLoadingScreen.setBackground(new java.awt.Color(204, 204, 255));
        pnlLoadingScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlLoadingScreen.add(jProgressBarloading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 770, 21));

        lblLoadingScreen.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblLoadingScreen.setForeground(new java.awt.Color(255, 255, 255));
        lblLoadingScreen.setText("Loading...");
        pnlLoadingScreen.add(lblLoadingScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 110, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/courseWork/resources/luis-sanchez-xYiOWrQ7n7M-unsplash (1)_1.jpg"))); // NOI18N
        pnlLoadingScreen.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLoadingScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLoadingScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Starts the timer to update the progress bar
    private void startLoading() {
        timer = new Timer(50, new ActionListener() { // Update every 50ms
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += 2; // Increment progress
                jProgressBarloading.setValue(progress); // Set progress bar value
                lblLoadingScreen.setText("Loading... " + progress + "%");

                // Check if loading is complete
                if (progress >= 100) {
                    timer.stop(); // Stop the timer
                    switchToLoginScreen(); // Switch to LoginScreen
                }
            }
        });
        timer.start(); // Start the timer
    }
    // Switch to the LoginScreen
    private void switchToLoginScreen() {
        this.dispose(); // Close the LoadingScreen
        new LoginScreen().setVisible(true); // Open the LoginScreen
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadingScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBarloading;
    private javax.swing.JLabel lblLoadingScreen;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnlLoadingScreen;
    // End of variables declaration//GEN-END:variables
}