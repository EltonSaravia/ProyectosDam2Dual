import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

    }
}
