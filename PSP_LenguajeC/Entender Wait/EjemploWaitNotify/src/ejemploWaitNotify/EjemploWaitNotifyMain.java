package ejemploWaitNotify;

public class EjemploWaitNotifyMain {

	public static void main(String[] args) {
		// Objeto en comun, se encargara del wait y notify
		Saludo hi = new Saludo();

		/*instancia de los hilos y le passamos los parametros:
		 * 
		 * 1- El nombre del hilo( en este caso el nombre de la persona) 
		 * 2- El objeto comun (Saludo) 
		 * 3- El booleano para comprobar si es Profesor o Alumno
		 */

		Persona Alumno1 = new Persona("Ruben", hi, false);
		Persona Alumno2 = new Persona("Pablo", hi, false);
		Persona Alumno3 = new Persona("Felix", hi, false);
		Persona Profesor = new Persona("Carlos", hi, true);

		// Lanzo los hilos

		Alumno1.start(); // AUNQUE LOS ALUMNOS LLEGUEN ANTES DEBEN ESPERAR AL PROFESOR PARA SALUDAR
		Alumno2.start();
		Alumno3.start();
		Profesor.start();

	}

}
