/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CARLOS
 */
public class ConexionConsulta {
    static Statement sentencia;
    //static Resultset resultado;
    
    public static ArrayList<String> llenar_combo()
    {
        ArrayList<String>listaApe = new ArrayList<String>();
        String consulta = "SELECT * FROM EMPLEADO";
        
        try {
            //resultado = (Resultset) sentencia.executeQuery(consulta);
            ResultSet resultado = sentencia.executeQuery("consulta");
            
            while(resultado.next())
            {
                listaApe.add(resultado.getString("APELLIDO"));
            }
        } catch (Exception e) {
        }        
        return listaApe;
    }

}
