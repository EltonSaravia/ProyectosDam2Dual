import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_DB {

    private static final String URL = "jdbc:sqlite:BD_Academia_Futbol.db"; // Cambia esto según tu configuración
    private static Connection conexion;

    // Método para obtener la conexión a la base de datos
    public static Connection obtenerConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conexion = DriverManager.getConnection(URL);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
