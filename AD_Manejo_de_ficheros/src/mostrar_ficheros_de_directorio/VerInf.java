package mostrar_ficheros_de_directorio;
import java.io.*;

public class VerInf {
	public static void main (String[] args) {
		System.out.println("Informacion sobre el fichero:");
		File f = new File ("VerInf.java");
		if (f.exists()) {
			System.out.println("Nombre del fichero:"+ f.getName());	
			System.out.println("Direccion del fichero:"+ f.getPath());
			System.out.println("Ruta absouta del fichero:"+ f.getAbsolutePath());
			System.out.println("Se puede escribir :"+ f.canWrite());
			System.out.println("Se puede Leer :"+ f.canRead());	
			System.out.println("Tamano:"+ f.length());	
			System.out.println("Es fichero:"+ f.isFile());
			System.out.println("Es directorio:"+ f.isDirectory());	
		}
	}
}