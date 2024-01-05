/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrdenarTabla.gto;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Alumno {
    
      
    private String nombre;
    private String asignatura;
    private int curso;
    private int nota ;
    private boolean repetidor;

    public Alumno( String nombre, String asignatura, int curso, int nota , boolean repetidor) {
        
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.curso = curso;
        this.nota = nota;
        this.repetidor = repetidor;
    }

   
    public String [] toArrayStrings(){
        String [] s = new String[5];
        
        s[0] = this.nombre;
        s[1] = this.asignatura;
        s[2] = this.curso+"";
        s[3] = this.nota+"";
        if(this.repetidor == true){
            s[4] = "si";
        }else{
            s[4] = "no";
        }
        
        
        return s;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }
    
}
