/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrdenarTabla.logica;

import OrdenarTabla.gto.Alumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LogicaAlumnos {
    private static List<Alumno> listaAlumnos = new ArrayList<>();
    
    public static void aniadirAlumno (Alumno alumno){
            listaAlumnos.add(alumno);
    }
    
    public static void eliminarAlumno (int cliente){
            listaAlumnos.remove(cliente);
    }
    public static List<Alumno> getListaAlumnos(){
        
        return listaAlumnos;
    }
}
