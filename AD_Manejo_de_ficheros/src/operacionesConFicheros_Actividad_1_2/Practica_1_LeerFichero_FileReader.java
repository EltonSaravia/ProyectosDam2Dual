package operacionesConFicheros_Actividad_1_2;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * Leer el contenido de un fichero en grupos de 20 en 20.
 *  Probar a realizar la declaración directamente con la clase FileReader 
 *  (sin crear un objeto File)
 */
public class Practica_1_LeerFichero_FileReader {
	public static void main (String [] args) {
		String fichero = "C:\\Users\\Usuario\\Desktop\\test.txt";
		
		FileReader fr = null;
		try {
			fr = new FileReader(fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 0;
		char b[] = new char [20];
		
		try {
			while ((i = fr.read(b)) != 	-1) {
				System.out.println((b));
			
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
