
/*
La clase Connection se utiliza para representar la conexión a una base de datos. 
La clase DriverManager administra un conjunto de controladores de base de datos. 
Los controladores son utilizados para establecer la conexión con la base de datos.
*/
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    /*
     * Declara una variable de tipo Connection llamada conectar. 
     * Esta variable se utilizará para almacenar la conexión a la base de datos.
     */
    Connection conectar;

    /*
     * Define un método público llamado conectar que devuelve un objeto de tipo Connection. 
     * Este método se utilizará para establecer la conexión con la base de datos.
     */
    public Connection conectar() {
        try {
            /*"Class.forName" Carga dinámicamente el controlador JDBC (Java Database Connectivity) para SQLite. 
            Este paso es necesario para registrar el controlador en el programa y permite que Java se comunique 
            con la base de datos SQLite.
             */
             
            Class.forName("org.sqlite.JDBC"); 
            conectar = DriverManager.getConnection("jdbc:sqlite:BD.db"); // El prefijo "jdbc:sqlite:" indica que se está utilizando el controlador JDBC para SQLite.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al conectar a la base de datos.");
        }
        return conectar;
    }
}
