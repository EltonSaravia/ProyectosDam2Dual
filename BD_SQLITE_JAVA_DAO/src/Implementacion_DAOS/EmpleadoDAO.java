package Implementacion_DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tablas.Empleado;

public class EmpleadoDAO implements IDao<Empleado, Integer> {
    private Connection conexion;

    public EmpleadoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean createRecord(Empleado empleado) {
        String query = "INSERT INTO empleado (nombre, apellidos, DNI, salario, id_departamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellidos());
            statement.setString(3, empleado.getDNI());
            statement.setDouble(4, empleado.getSalario());
            statement.setInt(5, empleado.getIdDepartamento());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Empleado readRecord(Integer id) {
        String query = "SELECT * FROM empleado WHERE id_empleado = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idEmpleado = resultSet.getInt("id_empleado");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String DNI = resultSet.getString("DNI");
                double salario = resultSet.getDouble("salario");
                int idDepartamento = resultSet.getInt("id_departamento");
                return new Empleado(idEmpleado, nombre, apellidos, DNI, salario, idDepartamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRecord(Empleado empleado, Integer id) {
        String query = "UPDATE empleado SET nombre = ?, apellidos = ?, DNI = ?, salario = ?, id_departamento = ? WHERE id_empleado = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellidos());
            statement.setString(3, empleado.getDNI());
            statement.setDouble(4, empleado.getSalario());
            statement.setInt(5, empleado.getIdDepartamento());
            statement.setInt(6, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecord(Integer id) {
        String query = "DELETE FROM empleado WHERE id_empleado = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Empleado> readRecords() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        try (PreparedStatement statement = conexion.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idEmpleado = resultSet.getInt("id_empleado");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String DNI = resultSet.getString("DNI");
                double salario = resultSet.getDouble("salario");
                int idDepartamento = resultSet.getInt("id_departamento");
                empleados.add(new Empleado(idEmpleado, nombre, apellidos, DNI, salario, idDepartamento));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
