package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteDBManager {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establece la URL de conexión a la base de datos SQLite
            String url = "jdbc:sqlite:BD.db";

            // Conecta a la base de datos o la crea si no existe
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Conexión a la base de datos establecida.");

                // Crea una tabla si no existe
                Statement statement = connection.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS mi_tabla (id INT PRIMARY KEY, nombre TEXT);";
                statement.execute(createTableSQL);

                System.out.println("Tabla creada con éxito.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
