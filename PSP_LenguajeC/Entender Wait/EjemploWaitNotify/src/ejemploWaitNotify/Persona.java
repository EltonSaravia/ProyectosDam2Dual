package ejemploWaitNotify;
// con el extends Thread nos aseguramos que se pueda sobresescribir el metodo run
public class Persona extends Thread { 

	String nombre;
	Saludo saludo;
	boolean esProfesor;

	public Persona(String nombre, Saludo saludo, boolean esProfesor) {
		super();
		this.nombre = nombre;
		this.saludo = saludo;
		this.esProfesor = esProfesor;
	}

	public void run() {
		System.out.println(this.nombre + " llegó.");
		/*
		 * se verifica si es profesor o si es alumno y saca el metodo saludar que hara
		 * cosas diferentes dependieto del boolean esProfesor
		 */
		if (esProfesor) {
			this.saludo.saludoProfesor(this.nombre);
		} else {
			this.saludo.saludoAlumno(this.nombre);
		}

	}
}
