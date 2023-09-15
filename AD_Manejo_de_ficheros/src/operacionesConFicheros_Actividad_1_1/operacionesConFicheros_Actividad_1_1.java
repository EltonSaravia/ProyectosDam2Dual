/*
 * Realiza un programa Java que utilice el método listFiles() para mostrar la lista de ficheros 
 * en un directorio cualquiera.
	Realiza un programa en Java que muestre los ficheros de un directorio.
	El nombre del directorio se pasará al programa desde los argumentos de main().  
	Si el directorio no existe se debe mostrar un mensaje indicándolo.
 */

package operacionesConFicheros_Actividad_1_1;
import java.io.File;
import java.util.Scanner;

	
public class operacionesConFicheros_Actividad_1_1 {
    public static void main(String[] args) {
    	//Declaro el Scanner y solicito que el usuario ingrese un directorio 
    	 Scanner sc=new Scanner(System.in);
    	System.out.println("Inserte la direccion del directorio"); 
    	String directorio =sc.nextLine(); // ejemplo : C:\Program Files\Internet Explorer
        
    	// Alamaceno el directorio con la clase File 
        File directorioFile = new File(directorio);
        /* compruebo si el directorio existe y si es una direccion valida sintacticamente 
        con los metodos Exists y isDirectory de la Clase File*/
        if (!directorioFile.exists() || !directorioFile.isDirectory()) {
            System.out.println("El directorio especificado no existe o no es un directorio válido.");
            return;
        }
        /*File[ ] listFiles(): devuelve un array de objetos File, 
         conteniendo los ficheros que están dentro del directorio. Los almaceno en un Array */
        File[] archivos = directorioFile.listFiles();

        /*Verifico que el array de ficheros no este vacio(NULL) 
        (¡se almacenan directorios y ficheros, NO SOLO LOS FICHEROS!)
        Utilizo 2 comprobaciones redundantes porquesi tiene más de un objeto no debe ser null.
        */
        if ( archivos.length > 0 && archivos != null) {
        	System.out.println("Objetos Encontrados: '" + archivos.length);
            System.out.println("Ficheros en el directorio: \n'" + directorio + "':\n");
            /* Recorroe el array de archivos con un ForEach y utilizo un
             * condicional para filtrar los ficheros, ya que si no utilizo el metodo isFile
             * me muetra tambien los directorio. ¡Preguntar a profesor!*/
            for (File archivo : archivos) {
               if (archivo.isFile()) {
                    System.out.println(archivo.getName()); // tomo el nombre del objeto y lo muestro
               }
            }
        } else {
            System.out.println("El directorio '" + directorio + "' \nEstá vacío.");
        }
    }
}
