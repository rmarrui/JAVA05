/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author ramar
 */
public class Conexion {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static ArrayList lista = null;
    
    public Conexion(){
        try {
            con = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            System.err.println("Error al hacer la conexión.");
        }
    }
    
    public boolean isFirst() throws SQLException{
        return rs.isFirst();
    }
    
    public boolean isLast() throws SQLException{
        return rs.isLast();
    }
    // Metodo que prepara el ResultSet para recorrer los datos 1 a 1, según la query s
    
    public void iniciaRecorrido(String s){
        try {
            if(rs != null && !rs.isClosed())        // Cierra rs y stmt para empezar de 0
                rs.close();
            if(stmt != null && !stmt.isClosed())
                stmt.close();
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(s);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Para devolver los datos del result set actual
    
    public ArrayList datosActual(){
        ArrayList l = new ArrayList();
        Object a;
        
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            for(int i = 1; i<= columnas; i++){
                a = rs.getObject(i);
                if(a instanceof Integer){
                    l.add(Integer.toString((int)a));
                }
                else if (a instanceof Float){
                    l.add(Float.toString((float)a));
                } else if (a instanceof Date){
                    l.add(((Date)a).toString());
                } else if (a instanceof BigDecimal){
                    l.add(String.valueOf(a));
                }
                else
                    l.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return l;
        }
    }
    
    public boolean siguienteRegistro(){
        try{
            rs.next();
            return true;
        }catch (SQLException ex){
            return false;
        }
    }
    
    public boolean anteriorRegistro(){
        try{
            rs.previous();
            return true;
        }catch (SQLException ex){
            return false;
        }
    }
    
    // Metodo que inserta en un ArrayList los resultados de la query. Necesita indicar el numero de campos, y conviene vaciar la lista antes de llamarlo.
    
    public ArrayList<ArrayList> ejecutaQuery(String s){
        ArrayList<ArrayList> l = new ArrayList<ArrayList>();
        ArrayList aux = new ArrayList();
        try (Statement stmt_query = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)){
            try(ResultSet rs_query = stmt_query.executeQuery(s)){
                ResultSetMetaData rsmd = rs_query.getMetaData();
                int columnas = rsmd.getColumnCount();
                while(rs_query.next()){
                    for(int i = 1; i<=columnas;i++){
                        aux.add(rs_query.getObject(i));
                        System.out.println(aux.get(aux.size()-1));
                    }
                    l.add(aux);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la sentencia SQL.");
        }
        finally{
            return l;
        }
    }
    
    public void close(){
        try {
            if(rs != null && !rs.isClosed())
                rs.close();
            if(stmt != null && !stmt.isClosed())
                stmt.close();
            if(con != null && !con.isClosed())
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static ArrayList getDataBD(String consulta)
    {
        try
        {
            lista = new ArrayList();
            
            con = ConnectionFactory.getConnection();
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(consulta);
            
            while(rs.next())
            {
                Empleado emp = new Empleado (rs.getString(1),
                                                    rs.getString(2),
                                                    rs.getString(3),
                                                    rs.getString(4),
                                                    rs.getString(5),
                                                    rs.getString(6),
                                                    rs.getString(7));
                lista.add(emp);
            }
            
            rs.close();
        }
        catch(SQLException e)
        {
            System.out.println("Se ha producido un error con la conexion de la BD");
            JOptionPane.showMessageDialog(null, "Se ha producido un error con la conexion de la BD"); 
        }
        
        ConnectionFactory.close(stmt);
        ConnectionFactory.close(con);
        
        return lista;
    }
}
