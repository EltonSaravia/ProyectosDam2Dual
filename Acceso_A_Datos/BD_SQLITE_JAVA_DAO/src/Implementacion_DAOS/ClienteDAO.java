package Implementacion_DAOS;

/*importaciones de clases relacionadas con SQL, JDBC (Java Database Connectivity) y 
la clase Cliente desde el paquete tablas. */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tablas.Cliente;

/*
La clase ClienteDAO implementa una interfaz IDao con parámetros de tipo Cliente e Integer, 
lo que indica que esta clase se encarga de acceder a datos de clientes y
 utiliza identificadores enteros para las operaciones. */
public class ClienteDAO implements IDao<Cliente, Integer> {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /*
     * La clase tiene un constructor que recibe una conexión a la base de datos como
     * parámetro.
     * La conexión se utiliza para ejecutar consultas SQL en la base de datos.
     */
    @Override
    public boolean createRecord(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente (nombre, persona_contacto, tfno_contacto, CIF, ubicacion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getPersonaContacto());
            statement.setString(3, cliente.getTfnoContacto());
            statement.setString(4, cliente.getCIF());
            statement.setString(5, cliente.getUbicacion());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * La clase implementa los métodos definidos en la interfaz IDao, que incluyen:
     * 
     * createRecord(Cliente cliente): Inserta un nuevo registro de cliente en la
     * base de datos.
     * readRecord(Integer id): Lee un registro de cliente por su identificador.
     * updateRecord(Cliente cliente, Integer id): Actualiza un registro de cliente
     * en la base de datos.
     * deleteRecord(Integer id): Elimina un registro de cliente de la base de datos.
     * readRecords(): Lee y devuelve una lista de todos los registros de clientes en
     * la base de datos.
     */
    @Override
    public Cliente readRecord(Integer id) {
        try {
            String query = "SELECT * FROM cliente WHERE id_cliente = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("persona_contacto"),
                        resultSet.getString("tfno_contacto"),
                        resultSet.getString("CIF"),
                        resultSet.getString("ubicacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRecord(Cliente cliente, Integer id) {
        try {
            String query = "UPDATE cliente SET nombre = ?, persona_contacto = ?, tfno_contacto = ?, CIF = ?, ubicacion = ? WHERE id_cliente = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getPersonaContacto());
            statement.setString(3, cliente.getTfnoContacto());
            statement.setString(4, cliente.getCIF());
            statement.setString(5, cliente.getUbicacion());
            statement.setInt(6, id);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecord(Integer id) {
        try {
            String query = "DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * Los métodos readRecord y readRecords recuperan datos de la base de datos
     * utilizando un ResultSet y
     * crean objetos Cliente a partir de los resultados para devolverlos.
     */
    @Override
    public List<Cliente> readRecords() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM cliente";
            PreparedStatement statement = conexion.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("persona_contacto"),
                        resultSet.getString("tfno_contacto"),
                        resultSet.getString("CIF"),
                        resultSet.getString("ubicacion"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
