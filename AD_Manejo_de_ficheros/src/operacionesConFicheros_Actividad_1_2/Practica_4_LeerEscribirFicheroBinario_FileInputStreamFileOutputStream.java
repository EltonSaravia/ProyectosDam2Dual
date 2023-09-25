package operacionesConFicheros_Actividad_1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * Práctica 4 - Escribir un fichero binario y leerlo (FileInputStream/FileOutputStream)
 * Escribir datos a un fichero binario (.dat) y después leer el contenido de ese fichero 
 * binario para sacarlo por pantalla.  
 * Agregar una sección del código que añade datos al final del fichero.
 */
public class Practica_4_LeerEscribirFicheroBinario_FileInputStreamFileOutputStream {

    public static void main(String[] args) {
        // Definimos el nombre del archivo binario en el que vamos a escribir y leer datos:
        String fileName = "datos.dat";

        // Creamos un bloque try-catch para manejar las posibles excepciones de E/S 
        try {
            /*
             * Creo un objeto DataOutputStream para escribir datos binarios en el archivo datos.bin. 
             * FileOutputStream se utiliza para abrir el archivo en modo de escritura.
             * Definimos una cadena dataToWrite que contiene el texto que queremos escribir en el archivo.
             * Usamos el método writeUTF para escribir la cadena en el archivo.
             * Finalmente, cerramos el DataOutputStream para liberar los recursos.
             */
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
            String dataToWrite = "¡Hola, que tal ?!";
            dos.writeUTF(dataToWrite);
            dos.close();

            System.out.println("");

            /*
             * Creamos un objeto DataInputStream para leer datos binarios del archivo datos.bin. 
             * FileInputStream se utiliza para abrir el archivo en modo de lectura.
             * Usamos el método readUTF para leer una cadena desde el archivo.
             * Cerramos el DataInputStream para liberar los recursos.
             */
            DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
            String dataRead = dis.readUTF();
            dis.close();

            System.out.println("Datos leídos del archivo binario:");
            System.out.println( dataRead);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
