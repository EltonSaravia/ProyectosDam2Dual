package com.example.lista_de_personas;

public class Persona {

    private int idPersona;
    private String nombre,cargo,empresa;

    public  Persona (int idPersona, String nombre, String cargo, String empresa){
        this.idPersona = idPersona;
        this.nombre  = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
