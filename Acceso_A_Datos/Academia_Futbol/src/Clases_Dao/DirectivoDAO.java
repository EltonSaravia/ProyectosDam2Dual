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
    public boolean guardarJugadorBD(Directivo directivo) {
        try {
            String consulta = "INSERT INTO Directivo (cargo) VALUES (?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, directivo.getCargo());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Directivo leerJugadorBD(Integer id) {
        try {
            String consulta = "SELECT * FROM Directivo WHERE id_directivo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Directivo directivo = new Directivo();
                        directivo.setId(rs.getInt("id_directivo"));
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
    public boolean actualizarJugadorBD(Directivo directivo, Integer id) {
        try {
            String consulta = "UPDATE Directivo SET cargo = ? WHERE id_directivo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, directivo.getCargo());
                ps.setInt(2, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean borrarJugadorBD(Integer id) {
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
