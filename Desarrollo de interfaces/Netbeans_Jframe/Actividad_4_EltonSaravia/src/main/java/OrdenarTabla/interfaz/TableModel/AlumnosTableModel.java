/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrdenarTabla.interfaz.TableModel;

import OrdenarTabla.gto.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class AlumnosTableModel extends AbstractTableModel{
    
    private List<Alumno> listAlumno;
    private String[] columnas = {"Nombre","Asignatura","Curso", "Nota", "Repetidor"};

    public AlumnosTableModel(List<Alumno> listAlumno) {
        this.listAlumno = listAlumno;
    }

    @Override
    public int getRowCount() {
        return listAlumno.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return listAlumno.get(rowIndex).getNombre();
                
            case 1:
                 return listAlumno.get(rowIndex).getAsignatura();
            case 2:
                 return listAlumno.get(rowIndex).getCurso();
            case 3:
                 return listAlumno.get(rowIndex).getNota();
                 
             case 4:
                    String repetidor;
                 if(listAlumno.get(rowIndex).isRepetidor() == true){
                    repetidor = "si";
                }else{
                    repetidor = "no";
                }
                 return repetidor;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return columnas[column];
    }
    
    
    
}
