import java.util.HashSet;
import java.util.Set;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main {

	 public static void main(String[] args) {
	        // Iniciar la base de datos y probar los métodos
	        ODB odb = null;
	        

	        try {
	        	Set<Centro> listaDeCentros = new HashSet<>();
	        	
	        	
	            // Abrir la conexión con la base de datos
	        	Centro centro1 = new Centro();
	            centro1.setNom_centro("Centro A");
	            centro1.setCod_centro(1);
	            
	            listaDeCentros.add(centro1);

	            Centro centro2 = new Centro();
	            centro2.setNom_centro("Centro B");
	            centro2.setCod_centro(2);
	            // Configura más propiedades del centro si lo deseas
	            listaDeCentros.add(centro2);

	            // Crear y asignar directores a los centros
	            Profesor director1 = new Profesor();
	            director1.setNombre_ape("Juan");
	            centro1.setDirector(director1);

	            Profesor director2 = new Profesor();
	            director2.setNombre_ape("Ana");
	            centro2.setDirector(director2);
	            
	            /*Profesor director3 = new Profesor();
	            director1.setNombre_ape("Juan");
	            centro1.setDirector(director3);*/

	            // Crear asignaturas
	            Asignatura asignatura1 = new Asignatura();
	            asignatura1.setCod_asig("MAT101");
	            asignatura1.setNombre_asi("Matemáticas");

	            Asignatura asignatura2 = new Asignatura();
	            asignatura2.setCod_asig("FIS101");
	            asignatura2.setNombre_asi("Física");

	            // Asignar asignaturas a profesores (opcional)
	            director1.addAsignatura(asignatura1);
	            director2.addAsignatura(asignatura2);
	            
	            
	            System.out.println("Centros con director llamado Juan:");
	            for (Centro c : listaDeCentros) {
	                if (c.getDirector().getNombre_ape().contains("Juan")) {
	                    System.out.println(c.getNom_centro());
	                }
	            }

	            
	            Profesor profesorExistente = centro1.getDirector(); // Tomar el director de centro1
	            centro2.addProfesor(profesorExistente); // Añadirlo al centro2
	            profesorExistente.copiarA(centro2); // Copiar el profesor al centro2
	            
	            
	         // Eliminar un centro (ejemplo con centro1)
	            listaDeCentros.remove(centro1);

	            // Eliminar una asignatura (ejemplo con asignatura1)
	            director1.removeAsignatura(asignatura1);

	        } finally {
	            // Cerrar la base de datos
	            if (odb != null) {
	                odb.close();
	            }
	        }
	    }

    public static void crearCentro(Centro centro) {
        ODB odb = null;
        try {
            odb = ODBFactory.open("E:\\Documentos\\GitHub\\ProyectosDam2Dual\\Acceso_A_Datos\\NeoDatis_practica\\AD_actividad_4_2\\Profesorado.neodatis"); 
            odb.store(centro);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public static void eliminarCentro(int cod_centro) {
        ODB odb = null;
        try {
            odb = ODBFactory.open("tuBaseDeDatos.neodatis");
            Objects<Centro> centros = odb.getObjects(Centro.class);
            for (Centro c : centros) {
                if (c.getCod_centro() == cod_centro) {
                    odb.delete(c);
                    break;
                }
            }
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public static void crearAsignatura(Asignatura asignatura) {
        ODB odb = null;
        try {
            odb = ODBFactory.open("E:\\\\Documentos\\\\GitHub\\\\ProyectosDam2Dual\\\\Acceso_A_Datos\\\\NeoDatis_practica\\\\AD_actividad_4_2\\\\Profesorado.neodatis");
            odb.store(asignatura);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public static void eliminarAsignatura(String cod_asig) {
        ODB odb = null;
        try {
            odb = ODBFactory.open("E:\\\\Documentos\\\\GitHub\\\\ProyectosDam2Dual\\\\Acceso_A_Datos\\\\NeoDatis_practica\\\\AD_actividad_4_2\\\\Profesorado.neodatis");
            Objects<Asignatura> asignaturas = odb.getObjects(Asignatura.class);
            for (Asignatura a : asignaturas) {
                if (a.getCod_asig().equals(cod_asig)) {
                    odb.delete(a);
                    break;
                }
            }
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public static void crearProfesor(Profesor profesor) {
        ODB odb = null;
        try {
            odb = ODBFactory.open("E:\\\\Documentos\\\\GitHub\\\\ProyectosDam2Dual\\\\Acceso_A_Datos\\\\NeoDatis_practica\\\\AD_actividad_4_2\\\\Profesorado.neodatis");
            odb.store(profesor);
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public static void eliminarProfesor(int cod_prof) {
        ODB odb = null;
        try {
            odb = ODBFactory.open("E:\\\\Documentos\\\\GitHub\\\\ProyectosDam2Dual\\\\Acceso_A_Datos\\\\NeoDatis_practica\\\\AD_actividad_4_2\\\\Profesorado.neodatis");
            Objects<Profesor> profesores = odb.getObjects(Profesor.class);
            for (Profesor p : profesores) {
                if (p.getCod_prof() == cod_prof) {
                    odb.delete(p);
                    break;
                }
            }
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }
    
    
    public static void copiarProfesorAOtroCentro(int codProfesor, int codCentroOrigen, int codCentroDestino) {
        ODB odb = null;
        try {
            // Abrir la conexión con la base de datos
            odb = ODBFactory.open("E:\\\\Documentos\\\\GitHub\\\\ProyectosDam2Dual\\\\Acceso_A_Datos\\\\NeoDatis_practica\\\\AD_actividad_4_2\\\\Profesorado.neodatis");

            // Obtener el profesor y los centros involucrados
            Objects<Profesor> profesores = odb.getObjects(Profesor.class);
            Profesor profesor = null;
            Centro centroOrigen = null;
            Centro centroDestino = null;

            for (Profesor p : profesores) {
                if (p.getCod_prof() == codProfesor) {
                    profesor = p;
                    break;
                }
            }

            Objects<Centro> centros = odb.getObjects(Centro.class);
            for (Centro c : centros) {
                if (c.getCod_centro() == codCentroOrigen) {
                    centroOrigen = c;
                } else if (c.getCod_centro() == codCentroDestino) {
                    centroDestino = c;
                }
            }

            // Verificar que se hayan encontrado el profesor y los centros
            if (profesor != null && centroOrigen != null && centroDestino != null) {
                // Agregar el profesor al centro destino
                profesor.addCentro(centroDestino);
                centroDestino.addProfesor(profesor);

                // Persistir los cambios en la base de datos
                odb.store(profesor);
                odb.store(centroDestino);
            }

        } finally {
            // Cerrar la base de datos
            if (odb != null) {
                odb.close();
            }
        }
    }
}
