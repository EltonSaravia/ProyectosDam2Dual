import java.sql.Connection;

public class Conexion {
    Connection conectar;

    public Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:C:\\Users\a\Usuario\Documents\GitHub\ProyectosDam2Dual\BD_SQLITE_JAVA_DAO\BD.db");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al conectar a la base de datos.");
        }
        return conectar;
    }
}
