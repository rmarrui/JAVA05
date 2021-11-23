/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author CARLOS
 */
public class JFrameMenu extends javax.swing.JFrame {
    //public static Connection conexion;
    /**
     * Creates new form NewJFrame
     */
    public JFrameMenu() {
        initComponents();
        controlador.AccesoA.conectarBD();
        this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            Conexion.close();
            System.exit(0);
        }

    });
        //Conexion.abrirConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1JList = new javax.swing.JMenu();
        jMenuItemJList = new javax.swing.JMenuItem();
        jMenuVisualiza1a1 = new javax.swing.JMenu();
        jMenuItem2Visualiza1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1JList.setText("JList");

        jMenuItemJList.setText("JList");
        jMenuItemJList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJListActionPerformed(evt);
            }
        });
        jMenu1JList.add(jMenuItemJList);

        jMenuBar1.add(jMenu1JList);

        jMenuVisualiza1a1.setText("Visualizar 1 a 1");

        jMenuItem2Visualiza1.setText("Visualizar 1 a 1 ");
        jMenuItem2Visualiza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2Visualiza1ActionPerformed(evt);
            }
        });
        jMenuVisualiza1a1.add(jMenuItem2Visualiza1);

        jMenuBar1.add(jMenuVisualiza1a1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2Visualiza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2Visualiza1ActionPerformed
        // TODO add your handling code here:
        
        cambiarContenedor(panel_Visualiza_a1);
        
        Conexion.abrirConexion();
        
        panel_Visualiza_a1.inicializaComboBox();
        panel_Visualiza_a1.iniciar();
        panel_Visualiza_a1.muestraNodo(); //mostramos ese primero de la lista
        
        
    }//GEN-LAST:event_jMenuItem2Visualiza1ActionPerformed

    private void jMenuItemJListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJListActionPerformed
        // TODO add your handling code here:
        panel_Visualiza_JList.iniciarJlist();
        cambiarContenedor(panel_Visualiza_JList);
    }//GEN-LAST:event_jMenuItemJListActionPerformed

    private void cambiarContenedor(javax.swing.JPanel aux) { //usamos un método para ir cambiando cada panel. Así solo lo escribimos una vez
        Conexion.close();
        this.setContentPane(aux);
        pack();
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
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMenu().setVisible(true);
            }
        });
    }
    
    private JPanelList  panel_Visualiza_JList = new JPanelList();
    private JVisualizar1a1 panel_Visualiza_a1 = new JVisualizar1a1();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1JList;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2Visualiza1;
    private javax.swing.JMenuItem jMenuItemJList;
    private javax.swing.JMenu jMenuVisualiza1a1;
    // End of variables declaration//GEN-END:variables
}
