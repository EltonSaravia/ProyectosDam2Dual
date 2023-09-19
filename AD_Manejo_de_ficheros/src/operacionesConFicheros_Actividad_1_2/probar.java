package operacionesConFicheros_Actividad_1_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class probar {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\\\Users\\\\Usuario\\\\Desktop\\\\prueba.txt"; // Reemplaza con el nombre de tu archivo
        
        try (
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))
        ) {
            String linea;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                System.out.println("Línea " + numeroLinea + ": " + linea);
                String nuevaLinea = "Línea " + numeroLinea + ": " + linea;
                bw.write(nuevaLinea);
                bw.newLine();
                numeroLinea++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
