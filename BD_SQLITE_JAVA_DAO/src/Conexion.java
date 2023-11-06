import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conectar;

    public Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:BD.db");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }
}
