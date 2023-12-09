import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectivoDAO implements IDao<Directivo, Integer> {

    private Connection conexion;

    public DirectivoDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean guardar_en_BD(Directivo directivo) {
        try {
            String consulta = "INSERT INTO Directivo (dni, nombre, apellidos, cargo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, directivo.getDni());
                ps.setString(2, directivo.getNombre());
                ps.setString(3, directivo.getApellidos());
                ps.setString(4, directivo.getCargo());

                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    // Obtener el ID generado para el nuevo directivo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            directivo.setId(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("No se pudo obtener el ID generado para el directivo.");
                        }
                    }
                }

                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Directivo leer_datos_BD(Integer id) {
        try {
            String consulta = "SELECT * FROM Directivo WHERE id_directivo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Directivo directivo = new Directivo();
                        directivo.setId(rs.getInt("id_directivo"));
                        directivo.setDni(rs.getString("dni"));
                        directivo.setNombre(rs.getString("nombre"));
                        directivo.setApellidos(rs.getString("apellidos"));
                        directivo.setCargo(rs.getString("cargo"));
                        return directivo;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public boolean actualizar_datos_BD(Directivo directivo, Integer id) {
        try {
            String consulta = "UPDATE Directivo SET dni = ?, nombre = ?, apellidos = ?, cargo = ? WHERE id_directivo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, directivo.getDni());
                ps.setString(2, directivo.getNombre());
                ps.setString(3, directivo.getApellidos());
                ps.setString(4, directivo.getCargo());
                ps.setInt(5, id);

                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean borrar_datos_BD(Integer id) {
        try {
            String consulta = "DELETE FROM Directivo WHERE id_directivo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Directivo> readRecords() {
        List<Directivo> directivos = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Directivo";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Directivo directivo = new Directivo();
                    directivo.setId(rs.getInt("id_directivo"));
                    directivo.setCargo(rs.getString("cargo"));

                    directivos.add(directivo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return directivos;
    }
}
