package operacionesConFicheros_Actividad_1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Practica_5_LecturaEscrituraPrimitivas_DataInputStream_DataOutputStream {

	 public static void main(String[] args) {
	        // Definimos el nombre del archivo binario en el que vamos a escribir y leer datos:
	        String fileName = "datos.dat";

	        // Creamos un bloque try-catch para manejar las posibles excepciones de E/S 
	        try {
	            /*
	             * Creamos un objeto DataOutputStream para escribir datos binarios. 
	             * FileOutputStream se utiliza para abrir el archivo en modo de escritura.
	             * Definimos dos variables, intValueToWrite y doubleValueToWrite, 
	             * que contienen los valores enteros y de doble precisión que queremos escribir en el archivo.
	             * Utilizamos los métodos writeInt y writeDouble para escribir estos valores en el archivo.
	             * Finalmente, cerramos el DataOutputStream para liberar los recursos.
	             */
	            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
	            int intValueToWrite = 42;
	            double doubleValueToWrite = 3.14159;
	            dos.writeInt(intValueToWrite);
	            dos.writeDouble(doubleValueToWrite);
	            dos.close();

	            System.out.println("Datos escritos en el archivo binario:");

	            /*
	             * Creamos un objeto DataInputStream para leer datos binarios del archivo. 
	             * FileInputStream se utiliza para abrir el archivo en modo de lectura.
	             * Utilizamos los métodos readInt y readDouble para leer los valores enteros 
	             * y de doble precisión desde el archivo.
	             * Cerramos el DataInputStream para liberar los recursos.
	             */
	            DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
	            int intValueRead = dis.readInt();
	            double doubleValueRead = dis.readDouble();
	            dis.close();

	            System.out.println("Datos leídos del archivo binario:");
	            System.out.println("Entero: " + intValueRead);
	            System.out.println("Doble: " + doubleValueRead);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
