/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author alumno
 */
public class JPanelList extends javax.swing.JPanel {

    private ArrayList<Empleado> lista = new ArrayList();
    private DefaultListModel<String> modelo;
    
    /**
     * Creates new form JPanelList
     */
    public JPanelList() {
        initComponents();
        modelo = new DefaultListModel<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListLista = new javax.swing.JList<>();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jXDatePickerFechaFin = new org.jdesktop.swingx.JXDatePicker();
        jXDatePickerFechaInicio = new org.jdesktop.swingx.JXDatePicker();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jListLista);

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jXDatePickerFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePickerFechaInicioActionPerformed(evt);
            }
        });

        jLabelFechaInicio.setText("Fecha Inicio");

        jLabelFechaFin.setText("Fecha Fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFiltrar)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelFechaInicio)
                        .addGap(18, 18, 18)
                        .addComponent(jXDatePickerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelFechaFin)
                        .addGap(27, 27, 27)
                        .addComponent(jXDatePickerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePickerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePickerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaInicio)
                    .addComponent(jLabelFechaFin))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(jButtonLimpiar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        jXDatePickerFechaInicio.setDate(null); //vaciamos los dos campos de la fecha
        jXDatePickerFechaFin.setDate(null);
        iniciarJlist();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd"); //CUIDADO: para las consultas es con este formato
        
        if(jXDatePickerFechaInicio.getDate() == null)
        {
            JOptionPane.showMessageDialog(jXDatePickerFechaInicio, "Hay que seleccionar una fecha de inicio");
        }
        else
        {
            if(jXDatePickerFechaFin.getDate() != null && jXDatePickerFechaInicio.getDate().compareTo(jXDatePickerFechaFin.getDate()) > 0) //si la fecha de fin no es nula y la de inicio es mayor que la de fin
            {
                JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser mayor que la final");
            }
            else
            {
                if(jXDatePickerFechaFin.getDate() == null)
                {
                    jXDatePickerFechaFin.setDate(new Date()); //si la final esta vacia ponemos la del sistema por defecto
                }
                
                String iniciofech = formatoDeFecha.format(jXDatePickerFechaInicio.getDate());
                String finalfech = formatoDeFecha.format(jXDatePickerFechaFin.getDate());

                Conexion.abrirConexion();
                lista = Conexion.getDataBD("SELECT * FROM EMPLEADO WHERE FECHAALTA BETWEEN '"+iniciofech+"' AND '"+finalfech+"' ORDER BY FECHAALTA DESC");
                jListLista.setModel(modeloPorDefecto());
                Conexion.close();
            }
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jXDatePickerFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePickerFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePickerFechaInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JList<String> jListLista;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFechaFin;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFechaInicio;
    // End of variables declaration//GEN-END:variables
   
    public void iniciarJlist(){
        Conexion.abrirConexion();
        lista = Conexion.getDataBD("SELECT * FROM EMPLEADO ORDER BY NUMERO");
        jListLista.setModel(modeloPorDefecto());
        Conexion.close();
    }
    
    public DefaultListModel modeloPorDefecto()
    {
        if(lista == null)
        {
            JOptionPane.showMessageDialog(null, "No hay ningun registro");
            modelo.addElement("No hay ningun registro");
        }
        else
        {
            modelo.removeAllElements(); //vaciamos el JList antes de introducir los campos nuevos
            
            for(Empleado emp: lista)
            {
                modelo.addElement(emp.toString());
            }
        }
        
        return modelo;
    }
}
