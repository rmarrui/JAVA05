/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author alumno
 */
public class JVisualizar1a1 extends javax.swing.JPanel {
/*
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
*/
    Conexion con;
    /**
     * Creates new form JPanelVer
     */
    public JVisualizar1a1() {
        con = new Conexion();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Salario = new javax.swing.JLabel();
        jLabel_Fecha = new javax.swing.JLabel();
        jLabel_SueldoMaximo = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jTextField_Salario = new javax.swing.JTextField();
        jTextField_Fecha = new javax.swing.JTextField();
        jTextField_SueldoMaximo = new javax.swing.JTextField();
        jButton_Siguiente = new javax.swing.JButton();
        jButton_Anterior = new javax.swing.JButton();
        jLabel_Titulo = new javax.swing.JLabel();
        jLabelCodEmpleado = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jLabel_Apellido = new javax.swing.JLabel();
        jTextField_Apellido = new javax.swing.JTextField();
        jComboBox_Apellidos = new javax.swing.JComboBox<>();
        jLabelFoto = new javax.swing.JLabel();

        jLabel_Nombre.setText("Nombre:");

        jLabel_Salario.setText("Salario: ");

        jLabel_Fecha.setText("Fecha:");

        jLabel_SueldoMaximo.setText("Sueldo máximo:");

        jTextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NombreActionPerformed(evt);
            }
        });

        jTextField_Salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SalarioActionPerformed(evt);
            }
        });

        jTextField_SueldoMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SueldoMaximoActionPerformed(evt);
            }
        });

        jButton_Siguiente.setText("Siguiente");
        jButton_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SiguienteActionPerformed(evt);
            }
        });

        jButton_Anterior.setText("Anterior");
        jButton_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AnteriorActionPerformed(evt);
            }
        });

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_Titulo.setText("DATOS EMPLEADO");

        jLabelCodEmpleado.setText("Número de empleado: ");

        jTextFieldCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodActionPerformed(evt);
            }
        });

        jLabel_Apellido.setText("Apellido: ");

        jComboBox_Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ApellidosActionPerformed(evt);
            }
        });

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Siguiente)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Fecha)
                            .addComponent(jLabel_SueldoMaximo)
                            .addComponent(jLabel_Salario)
                            .addComponent(jLabel_Nombre)
                            .addComponent(jLabelCodEmpleado)
                            .addComponent(jLabel_Apellido))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCod)
                            .addComponent(jTextField_Nombre)
                            .addComponent(jTextField_SueldoMaximo)
                            .addComponent(jTextField_Fecha)
                            .addComponent(jTextField_Salario)
                            .addComponent(jTextField_Apellido))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel_Titulo)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCodEmpleado)
                            .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Nombre)
                            .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Apellido)
                            .addComponent(jTextField_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Salario)
                            .addComponent(jTextField_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_SueldoMaximo)
                            .addComponent(jTextField_SueldoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Fecha)
                            .addComponent(jTextField_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Siguiente)
                            .addComponent(jButton_Anterior))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SiguienteActionPerformed
        // TODO add your handling code here:

        /*        if (!JFrameMenu.getLista().esUltimo()) { //mientras no hayamos llegado al final de la lista podremos avanzar al siguiente elemento 
            JFrameMenu.getLista().avanzar();
        } else {
            jButton_Siguiente.setEnabled(false); //si estamos al final de la lista inhabilitamos el boton de siguiente
        }

        this.muestraNodo(JFrameMenu.getLista()); //mostramos el nodo en el que estamos actualmente

        jButton_Anterior.setEnabled(true); //como no estamos en el primero el boton anterior lo habilitamos
         */
        if (avanzar()) {
            jButton_Anterior.setEnabled(true);
            muestraNodo();
            try {
                if(con.isLast())
                    jButton_Siguiente.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(JVisualizar1a1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton_SiguienteActionPerformed

    private void jTextField_SueldoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SueldoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SueldoMaximoActionPerformed

    private void jButton_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AnteriorActionPerformed
        // TODO add your handling code here:
        /*       if (!JFrameMenu.getLista().esPrimero()) { //mientras no hayamos llegado al principio de la lista podremos retorceder al anterior elemento 
            JFrameMenu.getLista().retroceder();
        } else {
            jButton_Anterior.setEnabled(false); //si estamos al principio de la lista inhabilitamos el boton de anterior
        }

        this.muestraNodo(JFrameMenu.getLista()); //mostramos el nodo en el que estamos actualmente

        jButton_Siguiente.setEnabled(true); //como no estamos en el ultimo el boton siguiente lo habilitamos
         */
        if (retroceder()) {
            jButton_Siguiente.setEnabled(true);
            muestraNodo();
            try {
                if(con.isFirst())
                    jButton_Anterior.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(JVisualizar1a1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_AnteriorActionPerformed

    private void jTextField_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NombreActionPerformed

    private void jTextFieldCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodActionPerformed

    private void jTextField_SalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SalarioActionPerformed

    private void jComboBox_ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ApellidosActionPerformed
        // TODO add your handling code here:
        if(((String) jComboBox_Apellidos.getSelectedItem()).equals("TODOS")){
            con.iniciaRecorrido("SELECT * FROM EMPLEADO");
        }
        else{
            con.iniciaRecorrido("SELECT * FROM EMPLEADO WHERE APELLIDO = '" + ((String) jComboBox_Apellidos.getSelectedItem())+"'");
        }
        con.siguienteRegistro();
        muestraNodo();
    }//GEN-LAST:event_jComboBox_ApellidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Anterior;
    private javax.swing.JButton jButton_Siguiente;
    private javax.swing.JComboBox<String> jComboBox_Apellidos;
    private javax.swing.JLabel jLabelCodEmpleado;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabel_Apellido;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Salario;
    private javax.swing.JLabel jLabel_SueldoMaximo;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextField_Apellido;
    private javax.swing.JTextField jTextField_Fecha;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_Salario;
    private javax.swing.JTextField jTextField_SueldoMaximo;
    // End of variables declaration//GEN-END:variables

    public boolean iniciar() {
        
        try {
            con.iniciaRecorrido("SELECT * FROM EMPLEADO");
        /*    con = ConnectionFactory.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM EMPLEADO");

            if (rs.next()) {
                // rs.beforeFirst();
                return true;
            } else {
                return false;
            }*/
            con.siguienteRegistro();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean avanzar() 
    {
        return con.siguienteRegistro();
    }

    public boolean retroceder() 
    {
        return con.anteriorRegistro();
    }

    public void muestraNodo() {
        //jButtonFoto.setEnabled(false);
        ArrayList campos;
        
        //try {
            campos = con.datosActual();
            String foto = "/fotos/"+campos.get(3);
            jTextFieldCod.setText( (String) campos.get(0));
            jTextField_Nombre.setText((String) campos.get(1));
            jTextField_Apellido.setText((String) campos.get(2));
            jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource(foto)));
            //cambiaFoto(foto, jLabelFoto);
            jTextField_Salario.setText(((String) campos.get(4)) + " euros");
            jTextField_SueldoMaximo.setText(((String) campos.get(5)) + " euros");
            jTextField_Fecha.setText((String) campos.get(6));
            
        try {
            if(con.isFirst()){
                jButton_Anterior.setEnabled(false);
            }
            if(con.isLast()){
                jButton_Siguiente.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JVisualizar1a1.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        /*} catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

/*    public void cambiaFoto(String url, JLabel label){
        BufferedImage foto = null;
        try{
            foto = ImageIO.read(new File(url));
        }catch(IOException e){
            e.printStackTrace();
        }
        
        Image foto_redimensionada = foto.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(foto_redimensionada);
        
        label.setIcon(icono);
    }*/
    
    public Icon setIcon(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));

        int ancho = boton.getWidth();
        int alto = boton.getHeight();

        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

        return icon;
    }

    public void inicializaComboBox() {
        ArrayList<ArrayList> listaApellidos = new ArrayList<ArrayList>();
        
        Conexion con_combo = new Conexion();
        
        listaApellidos = con_combo.ejecutaQuery("SELECT DISTINCT APELLIDO FROM EMPLEADO ORDER BY APELLIDO ASC");
        
        jComboBox_Apellidos.addItem("TODOS");
        
        for(int i=0; i<listaApellidos.size(); i++)
        {
            jComboBox_Apellidos.addItem((String) listaApellidos.get(0).get(i));
        }
        
        con_combo.close();
/*        Connection con_aux = null;
        Statement stmt_aux = null;
        ResultSet rs_aux = null;
        

        try {
            con_aux = ConnectionFactory.getConnection();
            stmt_aux = con_aux.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs_aux = stmt_aux.executeQuery("SELECT DISTINCT APELLIDO FROM EMPLEADO ORDER BY APELLIDO");
            
            this.jComboBox_Apellidos.addItem("NINGUNO");*/
            //HAY QUE CONECTARLO CON LA CLASE CONECTIONFACTORY
            //Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/empresa","empresa","empresa"); //abrimos la conexion con la BD
            /*con = ConnectionFactory.getConnection();
            stmt = con.createStatement(); //el objeto con el que vas a usar el SQL con esa BD
            rs = stmt.executeQuery("SELECT DISTINCT APELLIDO FROM empleado ORDER BY APELLIDO"); //objeto que va a usar la sentencia select que le indiques que afecta al estado
*/
 /*           while (rs_aux.next()) //mientras haya datos en la BD
            {
                this.jComboBox_Apellidos.addItem(rs_aux.getString("APELLIDO"));
            }

            rs_aux.close();
            stmt_aux.close();
            con_aux.close();
            //    con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        finally
        {
            ConnectionFactory.close(rs_aux);
            ConnectionFactory.close(stmt_aux);
            ConnectionFactory.close(con_aux);
        }*/

    }

    public void vaciarCampos() {
        jTextFieldCod.setText("1000");
        jTextField_Nombre.setText("******");
        jTextField_Apellido.setText("******");
        jTextField_Salario.setText(0.0 + " euros");
        jTextField_Fecha.setText("01/01/2000");
        jTextField_SueldoMaximo.setText(0.0 + " euros");
    }

}
