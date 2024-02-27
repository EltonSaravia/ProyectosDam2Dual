import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main {

	public static void main(String[] args) {
		// Iniciar la base de datos y probar los métodos
		ODB odb = ODBFactory.open("bdProfesores.neodatis");
		// Abrir la conexión con la base de datos

		try {
			Set<Centro> listaDeCentros = new HashSet<>();
			// croe las asignaturas primero porque antes medaba error el profesor a no
			// tenerlas
			Asignatura asignatura1 = new Asignatura();
			asignatura1.setCod_asig("MAT101");
			asignatura1.setNombre_asi("Matematicas");

			Asignatura asignatura2 = new Asignatura();
			asignatura2.setCod_asig("FIS101");
			asignatura2.setNombre_asi("Fisica");

			Asignatura asignatura3 = new Asignatura();
			asignatura2.setCod_asig("GEO101");
			asignatura2.setNombre_asi("Geologia");

			// empiezo a crear centros antes que profesores
			Centro centro1 = new Centro();
			centro1.setNom_centro("Centro A");
			centro1.setCod_centro(1);
			centro1.setDirector(null);

			listaDeCentros.add(centro1);

			Centro centro2 = new Centro();
			centro2.setNom_centro("Centro B");
			centro2.setCod_centro(2);

			listaDeCentros.add(centro2);

			// Crear y asignar directores a los centros
			Profesor director1 = new Profesor();
			director1.setNombre_ape("Juan");
			director1.setEspecialidad("ser Invisible");
			director1.setCod_prof(1);
			//Date fecha_de_ahora = new Date();
			//director1.setFecha_nac((java.sql.Date) fecha_de_ahora);
			director1.setSexo('H');
			// AHORA SE LE ASIGNAN LAS CLAVES FORANEAS
			director1.addAsignatura(asignatura1);
			centro1.setDirector(director1);

			// Crear y asignar directores a los centros
			Profesor director2 = new Profesor();
			director2.setNombre_ape("ANA");
			director2.setEspecialidad("Ser mejor que los otros profesores en todo");
			director2.setCod_prof(2); // ---> codigo importante para eliminar o modificar los datos de un objetoalumno
				//no me funciona el date debo darle un repaso
			//Date fecha_de_ahora12 = new Date();
			//director2.setFecha_nac((java.sql.Date) fecha_de_ahora12);
			director2.setSexo('F');
			// AHORA SE LE ASIGNAN LAS CLAVES FORANEAS
			director2.addAsignatura(asignatura1);
			centro2.setDirector(director2);

			// profesor que no es director para luego eliminarlo en plan bien
			Profesor profesor3 = new Profesor();
			profesor3.setNombre_ape("javi");
			profesor3.setEspecialidad("genera campos electricos");
			profesor3.setCod_prof(3);
			//Date fecha_de_ahora123 = new Date();
			//profesor3.setFecha_nac((java.sql.Date) fecha_de_ahora123);
			profesor3.setSexo('H');
			// AHORA SE LE ASIGNAN LAS CLAVES FORANEAS
			profesor3.addAsignatura(asignatura2);
			centro2.setDirector(profesor3);

			// profesor que no es director para luego meterlo en un nuevo centro
			Profesor profesor4 = new Profesor();
			profesor4.setNombre_ape("LUIS");
			profesor4.setEspecialidad("tener suerte ");
			profesor4.setCod_prof(3);
			//Date fecha_de_ahora1234 = new Date();
			//profesor4.setFecha_nac((java.sql.Date) fecha_de_ahora1234);
			profesor4.setSexo('H');
			// AHORA SE LE ASIGNAN LAS CLAVES FORANEAS
			profesor3.addAsignatura(asignatura3);
			centro2.setDirector(profesor4);

			/*
			 * System.out.println("Centros con director llamado Juan:"); for (Centro c :
			 * listaDeCentros) { if (c.getDirector().getNombre_ape().contains("Juan")) {
			 * System.out.println(c.getNom_centro()); } }
			 */

			/*
			 * ´ crear los obejtos en la base de datos
			 */
			
			odb.close();
			crearCentro(centro1);
			crearCentro(centro2);
			crearAsignatura(asignatura1);
			crearAsignatura(asignatura2);
			crearAsignatura(asignatura3);
			crearProfesor(director1);
			crearProfesor(director2);
			crearProfesor(profesor3);//
			crearProfesor(profesor4);

			/*
			 * elimino los objetos
			 */
			eliminarProfesor(3);
			
			/*
			 * Listar a todos los centros con el nombre Juan
			 */
			listarALosJuanes();
			

		} finally {// --> despues de haberlo hecho todo cierra
			// Cerrar la base de datos
			if (odb != null) {
				odb.close();
			}
		}
	}

	public static void listarALosJuanes() {
		ODB odb = ODBFactory.open("bdProfesores.neodatis");
		try {

			
			Objects<Centro> listaDeCentros = odb.getObjects(Centro.class); ///--> obtengo la lista de los centro

			System.out.println("Centros con director llamado Juan:");
			for (Centro c : listaDeCentros) {
				if (c.getDirector().getNombre_ape().contains("Juan")) {//--> con este comanto accedo al objeto centro y a sus atributos
					System.out.println(c.getNom_centro());
				}
			}
		} finally {
			if (odb != null) {
				odb.commit();
				odb.close();
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////
	public static void crearCentro(Centro centro) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("bdProfesores.neodatis");
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
			odb = ODBFactory.open("bdProfesores.neodatis");
			Objects<Centro> centros = odb.getObjects(Centro.class);
			for (Centro c : centros) {
				if (c.getCod_centro() == cod_centro) {
					odb.delete(c);
					odb.commit();
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
			odb = ODBFactory.open("bdProfesores.neodatis");
			odb.store(asignatura);
			odb.commit();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public static void eliminarAsignatura(String cod_asig) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("bdProfesores.neodatis");
			Objects<Asignatura> asignaturas = odb.getObjects(Asignatura.class);
			for (Asignatura a : asignaturas) {
				if (a.getCod_asig().equals(cod_asig)) {
					odb.delete(a);
					odb.commit();
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
			odb = ODBFactory.open("bdProfesores.neodatis");
			odb.store(profesor);
			odb.commit();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public static void eliminarProfesor(int cod_prof) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("bdProfesores.neodatis");
			Objects<Profesor> profesores = odb.getObjects(Profesor.class);
			for (Profesor p : profesores) {
				if (p.getCod_prof() == cod_prof) {
					odb.delete(p);
					odb.commit();
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

			// Obtener el profesor y los centros involucrados para poder hacer la
			// modificacion a 3 bandas --> no funciona bien
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
				// Agregar el profesor al centro destino--> debe hacerse el cambio en ambas
				// direcciones
				profesor.addCentro(centroDestino);
				centroDestino.addProfesor(profesor);

				// Guarda los nuevos profesores ? lo que no se es si crear un nuevo oid
				odb.store(profesor);
				odb.store(centroDestino);
				odb.commit();
			}

		} finally {
			// Cerrar la base de datos
			if (odb != null) {
				odb.close();
			}
		}
	}

}
