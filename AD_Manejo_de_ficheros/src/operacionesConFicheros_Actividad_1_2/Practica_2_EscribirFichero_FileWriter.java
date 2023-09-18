package operacionesConFicheros_Actividad_1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/*
 *En esta práctica hay que crear un fichero de texto con un editor cualquiera y 
 *después modificar su contenido con la clase FileWriter.  
 *Añadir un carácter cualquiera al final del fichero (p.e. una coma)
 *En el mismo código, añadir una sección en la que escriba el contenido de un 
 *String[] el fichero.
 */
public class Practica_2_EscribirFichero_FileWriter {

public static void main (String [] args) {
	// creo un array de Strings para la segunda seccion de la practica
	  String[] arrayString = {"Esto", "funciona", "?"};
	 
		try {
			//constructor de Filwriter con boolena para que no se elimine el texto anterior
			FileWriter nuevoFichero = new FileWriter("C:\\Users\\Usuario\\Desktop\\prueba.txt",  true);
			nuevoFichero.write("Hola que haces ? ");
			// bcle for each para recorrer el Array de palabaras y escribirlas.
			for (String palabra : arrayString) {
				 nuevoFichero.write(palabra + " ");
	            }
			char c = ';';
			nuevoFichero.append( c); //con append se añade un chart al final del texto
			nuevoFichero.write("\r\n"); //salto de linea
			
			//cierro el FileWriter creado
			nuevoFichero.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		
		
		}
	

}

