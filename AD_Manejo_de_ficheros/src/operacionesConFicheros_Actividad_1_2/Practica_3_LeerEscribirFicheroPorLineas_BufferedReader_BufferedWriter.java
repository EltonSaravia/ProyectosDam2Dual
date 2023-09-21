package operacionesConFicheros_Actividad_1_2;
/*
 * Práctica 3 - Leer/escribir fichero por líneas (BufferedReader/BufferedWriter)
 * Leer un fichero línea por línea y mostrarlo por pantalla.
 * Después, modificar el contenido del fichero del fichero (p.e. agregar el número de línea al principio) 
 * y volver a visualizar el contenido por pantalla.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
        try (BufferedReader lector1 = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            /*
             * se va leyendo el fichero línea a línea mediante bf.readLine() hasta que se acaban las líneas. 
             * Cuando no quedan más líneas por leer se devuelve el valor null.
             * Con un entero le voy indicando la linea que quiero leer y de forma 
             * incremental se leen todas las lineas enpezando por 1
             */
            int numeroLinea = 1;
            while ((linea = lector1.readLine()) != null) {
                System.out.println(linea);
                numeroLinea++;
            }
        } catch (IOException e) { //capturo la IOException que es generalizada
            e.printStackTrace();
        }
    /*
     * abro nuevamente 2 flujos, uno para leer y otro para escribir.
     * Al crear el BufferedWriter le pongo un directorio diferente para que cree u nuevo fichero
     * Luego leo linea a linea como antes y voy escribiendo linea a linea en el fichero auxiliar
     */
        try (BufferedReader lector2 = new BufferedReader(new FileReader(nombreArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo + ".temp"))) {
            String linea;
            int numeroLinea = 1;
            while ((linea = lector2.readLine()) != null) {
                String nuevaLinea = "Línea " + numeroLinea + ": " + linea;
                bw.write(nuevaLinea);
                bw.newLine();
                numeroLinea++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    /*
     * Renombrar el archivo temporal al nombre original Con la clase File
     */
        File originalFile = new File(nombreArchivo); 
        File newFile = new File(nombreArchivo+".temp");
        originalFile.delete(); // Elimina el archivo original
        newFile.renameTo(originalFile); // Cambia el nombre del archivo nuevo al original
        
        // Volver a visualizar el contenido por pantalla
        try (BufferedReader lector3 = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int numeroLinea = 1;
            while ((linea = lector3.readLine()) != null) {
                System.out.println(linea);
                numeroLinea++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /////////////////////////////////////////////////////
     /*
      * Podria haberlo unificado en un mismo Try Catch pero para ello 
      * debo cerrar cada flujo, de esta forma no hace falta cerrar los flujos
      * e incluso pueden llevar el mismo nombre.
      */

	}

}
