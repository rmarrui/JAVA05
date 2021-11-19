/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS
 */
public class Empleado {
    private int numero;
    private String nombre;
    private String apellido;
    private String foto;
    private float salario;
    private float salarioMaximo;
    private GregorianCalendar fechaAlta;

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    //*******************
    public int getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        
        try
        {
            this.numero = Integer.parseInt(numero);
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Se ha introducido en la columna NUMERO letras en vez de numeros");
        }
    }

    //*******************
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //*******************
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //*******************
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    //*******************
    public float getSalario() {
        return salario;
    }

    public void setSalario(String salario) {        
        try{
            this.salario = Float.parseFloat(salario);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Se ha introducido en la columna SALARIO letras en vez de numeros");
        }  
    }
    
    //*******************
    public float getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(String salarioMaximo) {        
        try{
            this.salarioMaximo = Float.parseFloat(salarioMaximo);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Se ha introducido en la columna SALARIO MAXIMO letras en vez de numeros");
        }  
    }

    //*******************
    public String getFechaAlta() {        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        return formatoFecha.format(fechaAlta.getTime());
    }

    public void setFechaAlta(String fechaAlta) {        
        String[] fechaAux = fechaAlta.split("-");
        
        this.fechaAlta = new GregorianCalendar(
                                                Integer.parseInt(fechaAux[0]), 
                                                Integer.parseInt(fechaAux[1]), 
                                                Integer.parseInt(fechaAux[2]));
    }
    
    //*******************
    //******CONSTRUCTOR*********
    public Empleado(String numero, String nombre, String apellido, String foto, String salario, String salarioMaximo, String fechaAlta) {
        this.setNumero(numero);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setFoto(foto);
        this.setSalario(salario);
        this.setSalarioMaximo(salarioMaximo);
        this.setFechaAlta(fechaAlta);
    }
    
    @Override
    public String toString()
    {
        return this.numero + "-" + this.nombre + "-" + this.apellido + "-" + this.foto + "-" + this.salario + "-" + this.salarioMaximo + "-" + sdf.format(fechaAlta.getTime());
    }
}
