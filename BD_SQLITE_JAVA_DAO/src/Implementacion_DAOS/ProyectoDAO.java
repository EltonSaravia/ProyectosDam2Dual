package Implementacion_DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tablas.Proyecto;

public class ProyectoDAO implements IDao<Proyecto, Integer> {
    private Connection conexion;

    public ProyectoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean createRecord(Proyecto proyecto) {
        String query = "INSERT INTO PROYECTO (nombre, id_departamento) VALUES (?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, proyecto.getNombre());
            statement.setInt(2, proyecto.getIdDepartamento());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Proyecto readRecord(Integer id) {
        String query = "SELECT * FROM PROYECTO WHERE id_proyecto = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Proyecto(
                        resultSet.getInt("id_proyecto"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("id_departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRecord(Proyecto proyecto, Integer id) {
        String query = "UPDATE PROYECTO SET nombre = ?, id_departamento = ? WHERE id_proyecto = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, proyecto.getNombre());
            statement.setInt(2, proyecto.getIdDepartamento());
            statement.setInt(3, id);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecord(Integer id) {
        String query = "DELETE FROM PROYECTO WHERE id_proyecto = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Proyecto> readRecords() {
        List<Proyecto> proyectos = new ArrayList<>();
        String query = "SELECT * FROM PROYECTO";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                proyectos.add(new Proyecto(
                        resultSet.getInt("id_proyecto"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("id_departamento")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyectos;
    }
}
