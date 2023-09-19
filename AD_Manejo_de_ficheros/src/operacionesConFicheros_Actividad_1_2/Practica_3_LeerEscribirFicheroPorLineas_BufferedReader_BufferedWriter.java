package operacionesConFicheros_Actividad_1_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practica_3_LeerEscribirFicheroPorLineas_BufferedReader_BufferedWriter {

	public static void main(String[] args) {
		//Aqui va la direccion del fichero que se modificará, debe tener contenido en texto
		String nombreArchivo = "C:\\Users\\Usuario\\Desktop\\prueba.txt"; 
        
        /*
         * Con el BufferedReader obtenemos el directorio y lo almacenamos en String. 
         * Le pasamos ese parametro como Directorio File al metodo FileReader()
         */
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            /*
             * se va leyendo el fichero línea a línea mediante bf.readLine() hasta que se acaban las líneas. 
             * Cuando no quedan más líneas por leer se devuelve el valor null.
             * Con un entero le voy indicando la linea que quiero leer y de forma 
             * incremental se leen todas las lineas enpezando por 1
             */
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                numeroLinea++;
            }
        } catch (IOException e) { //capturo la IOException que es generalizada
            e.printStackTrace();
        }
        
        // Modificar el contenido del archivo (agregar el número de línea al principio)
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            String linea;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                String nuevaLinea = "Línea " + numeroLinea + ": " + linea;
                bw.write(nuevaLinea);
                bw.newLine();
                numeroLinea++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    /*    // Renombrar el archivo temporal al nombre original
        try {
            java.nio.file.Files.delete(java.nio.file.Paths.get(nombreArchivo));
            java.nio.file.Files.move(java.nio.file.Paths.get(nombreArchivo + ".temp"), java.nio.file.Paths.get(nombreArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
        // Volver a visualizar el contenido por pantalla
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                numeroLinea++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        /////////////////////////////////////////////////////
     

	}

}
