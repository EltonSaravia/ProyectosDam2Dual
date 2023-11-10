import java.sql.Connection;

public class Conexion {
    Connection conectar;

    public Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:\BD.db");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al conectar a la base de datos.");
        }
        return conectar;
    }
}
