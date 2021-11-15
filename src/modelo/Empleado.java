/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author CARLOS
 */
public abstract class Empleado {
    private int numero;
    private String nombre;
    private String apellido;
    private String foto;
    private float sueldoMaximo;
    Date fechaAlta;

    
    //*******************
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    public float getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(float sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    //*******************
    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    //*******************
    //******CONSTRUCTOR*********
    public Empleado(int numero, String nombre, String apellido, String foto, float sueldoMaximo, Date fechaAlta) {
        this.numero = numero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.sueldoMaximo = sueldoMaximo;
        this.fechaAlta = fechaAlta;
    }
    
    
    public String toString(){
        String s = this.getNumero()+"*"
                + this.getNombre() + "*"
                + this.getApellido() + "*"
                + this.getSueldoMaximo();

        return s;
    }
}
