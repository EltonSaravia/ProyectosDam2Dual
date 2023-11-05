package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteExample {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            // Establecer la conexión a la base de datos SQLite
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlite:Bd_embebida_java_contruccion//empresa//conection//BD.db");

            // Crear una tabla
            Statement statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS empleados (id INTEGER PRIMARY KEY, nombre TEXT, salario REAL)");

            // Insertar datos
            statement.execute("INSERT INTO empleados (nombre, salario) VALUES ('Juan', 50000.0)");

            // Realizar consultas
            // ...

            // Cerrar la conexión
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
