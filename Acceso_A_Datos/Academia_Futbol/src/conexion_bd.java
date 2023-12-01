import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    /* Declara una variable de tipo Connection llamada conectar.  Esta variable se utilizará para almacenar la conexión a la base de datos. */
    private static final String URL = "jdbc:sqlite:BD_Academia_Futbol.db"; // Cambia esto según tu configuración
    private static Connection conexion;

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

}
