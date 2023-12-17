package ejemploWaitNotify;

public class Saludo {

	private boolean haLlegadoProfe;

	public Saludo() {

		this.haLlegadoProfe = false;
	}

	/*
	 * Si la persona que llega es Alumno , entonces se quedara esperando (wait()) a
	 * que llegue el profesor para saludar.
	 */
	public synchronized void saludoAlumno(String nombre) { // El synchronized permite establecer bloqueos
		try {
			if (!this.haLlegadoProfe) {
				wait(); // bloquea el proceso a espera de ser notificado
				System.out.println("\n" + nombre + ": Buenas tardes Carlos.");
			} else {
				System.out.println("\n" + nombre + ": Discupas por el retraso Carlos.");
			}
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*
	 * Si quien llega es el profesor, primero saludo y luego avisa a todos los
	 * alumnos que esten bloqueados esperando para que lo soluden con el notifyAll()
	 */

	public synchronized void saludoProfesor(String nombre) {
		System.out.println("\n" + nombre + ": Buenas tardes Chicos. ***********");
		this.haLlegadoProfe = true;
		notifyAll(); // metodo que desbloquea cualquier hilo a la espera en un wait().
	}

}
