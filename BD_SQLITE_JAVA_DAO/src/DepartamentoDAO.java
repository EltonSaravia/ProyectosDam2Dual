import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tablas.Departamento;

public class DepartamentoDAO implements IDao<Departamento, Integer> {
    private Connection conexion;

    public DepartamentoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean createRecord(Departamento model) {
        String sql = "INSERT INTO departamento (nombre, ubicacion) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, model.getNombre());
            statement.setString(2, model.getUbicacion());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Departamento readRecord(Integer id) {
        String sql = "SELECT * FROM departamento WHERE id_departamento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String ubicacion = resultSet.getString("ubicacion");
                return new Departamento(id, nombre, ubicacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRecord(Departamento model, Integer id) {
        String sql = "UPDATE departamento SET nombre = ?, ubicacion = ? WHERE id_departamento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, model.getNombre());
            statement.setString(2, model.getUbicacion());
            statement.setInt(3, id);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecord(Integer id) {
        String sql = "DELETE FROM departamento WHERE id_departamento = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Departamento> readRecords() {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM departamento";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_departamento");
                String nombre = resultSet.getString("nombre");
                String ubicacion = resultSet.getString("ubicacion");
                departamentos.add(new Departamento(id, nombre, ubicacion));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departamentos;
    }
}
