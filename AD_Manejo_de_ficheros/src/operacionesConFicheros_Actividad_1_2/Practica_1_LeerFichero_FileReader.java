package operacionesConFicheros_Actividad_1_2;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Practica_1_LeerFichero_FileReader {
	public static void main (String [] args) {
		File fichero = new File (("C:\\Users\\Usuario\\Desktop\\test.txt"));
		
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
