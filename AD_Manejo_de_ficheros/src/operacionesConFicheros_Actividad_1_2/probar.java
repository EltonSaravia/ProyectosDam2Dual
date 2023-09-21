package operacionesConFicheros_Actividad_1_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class probar {
	 public static void main(String[] args) {
	        // Nombre del archivo que deseas leer y modificar
		 String fileName = "C:\\Users\\Usuario\\Desktop\\prueba.txt";

	        try {
	            // Crear un objeto BufferedReader para leer el archivo
	            BufferedReader br = new BufferedReader(new FileReader(fileName));

	            // Leer y mostrar el contenido línea por línea
	            String line;
	            int lineNumber = 1;
	            while ((line = br.readLine()) != null) {
	                System.out.println("Línea " + lineNumber + ": " + line);
	                lineNumber++;
	            }

	            // Cerrar el BufferedReader
	            br.close();

	            // Modificar el archivo agregando el número de línea al principio
	            BufferedReader br2 = new BufferedReader(new FileReader(fileName));
	            BufferedWriter bw = new BufferedWriter(new FileWriter( fileName+".temp"));
	            
	            lineNumber = 1;
	            while ((line = br2.readLine()) != null) {
	                String newLine = "Línea " + lineNumber + ": " + line;
	                bw.write(newLine);
	                bw.newLine();
	                lineNumber++;
	            }

	            // Cerrar el BufferedReader y BufferedWriter
	            br2.close();
	            bw.close();

	            // Mostrar el contenido modificado
	            BufferedReader br3 = new BufferedReader(new FileReader(fileName+".temp"));
	            lineNumber = 1;
	            while ((line = br3.readLine()) != null) {
	                System.out.println("Línea " + lineNumber + ": " + line);
	                lineNumber++;
	            }
	            br3.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        File originalFile = new File(fileName);
            File newFile = new File(fileName+".temp");
            originalFile.delete(); // Elimina el archivo original
            newFile.renameTo(originalFile); // Cambia el nombre del archivo nuevo al original
	    }
    }        /////////////////////////


