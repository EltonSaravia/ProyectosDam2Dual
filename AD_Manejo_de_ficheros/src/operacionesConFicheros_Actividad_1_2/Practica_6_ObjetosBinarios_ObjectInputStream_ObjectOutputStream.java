package operacionesConFicheros_Actividad_1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Practica_6_ObjetosBinarios_ObjectInputStream_ObjectOutputStream {

	 public static void main(String[] args) throws IOException, ClassNotFoundException {
	        // Crear algunas instancias de Persona
	        Persona persona1 = new Persona("Alice", 30);
	        Persona persona2 = new Persona("Bob", 25);
	        Persona persona3 = new Persona("Charlie", 35);

	        // Escribir objetos Persona en un fichero binario
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.dat"));
	        oos.writeObject(persona1);
	        oos.writeObject(persona2);
	        oos.writeObject(persona3);
	        oos.close();

	        System.out.println("Objetos Persona escritos en el fichero binario.");

	        // Leer objetos Persona desde el fichero binario
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat"));
	        Persona personaLeida1 = (Persona) ois.readObject();
	        Persona personaLeida2 = (Persona) ois.readObject();
	        Persona personaLeida3 = (Persona) ois.readObject();
	        ois.close();

	        System.out.println("Objetos Persona leídos del fichero binario:");
	        System.out.println("Persona 1: " + personaLeida1.getNombre() + ", Edad: " + personaLeida1.getEdad());
	        System.out.println("Persona 2: " + personaLeida2.getNombre() + ", Edad: " + personaLeida2.getEdad());
	        System.out.println("Persona 3: " + personaLeida3.getNombre() + ", Edad: " + personaLeida3.getEdad());
	    }
	    
}
