/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclientes.dto;

import java.util.Date;


/**
 *
 * @author Usuario
 */
public class Cliente {
    private int numero;
    private String nombre;
    private String apellidos;
    private Date fechaAlta;
    private String provincia;

    public Cliente(int numero, String nombre, String apellidos, Date fechaAlta, String provincia) {
        this.numero = numero;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
        this.provincia = provincia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
        public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String [] toArrayStrings(){
        String [] s = new String[5];
        
        s[0] = this.numero + "";
        s[2] = this.nombre;
        s[3] = this.apellidos;
        s[4] = this.fechaAlta.toString();
        s[5] = this.provincia;
        
        return s;
    }
}
