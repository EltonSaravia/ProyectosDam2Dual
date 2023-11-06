package Implementacion_DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tablas.Cliente;

public class ClienteDAO implements IDao<Cliente, Integer> {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

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
