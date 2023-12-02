import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LesionDAO implements IDao<Lesion, Integer> {

    private Connection conexion;

    public LesionDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean createRecord(Lesion lesion) {
        try {
            String consulta = "INSERT INTO Lesion (fecha_inicio, fecha_fin, jugador) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, lesion.getFechaInicio());
                ps.setString(2, lesion.getFechaFin());
                ps.setString(3, lesion.getJugador());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Lesion readRecord(Integer id) {
        try {
            String consulta = "SELECT * FROM Lesion WHERE id_lesion = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Lesion lesion = new Lesion();
                        lesion.setIdLesion(rs.getInt("id_lesion"));
                        lesion.setFechaInicio(rs.getString("fecha_inicio"));
                        lesion.setFechaFin(rs.getString("fecha_fin"));
                        lesion.setJugador(rs.getString("jugador"));
                        return lesion;
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
    public boolean updateRecord(Lesion lesion, Integer id) {
        try {
            String consulta = "UPDATE Lesion SET fecha_inicio = ?, fecha_fin = ?, jugador = ? WHERE id_lesion = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, lesion.getFechaInicio());
                ps.setString(2, lesion.getFechaFin());
                ps.setString(3, lesion.getJugador());
                ps.setInt(4, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecord(Integer id) {
        try {
            String consulta = "DELETE FROM Lesion WHERE id_lesion = ?";
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
    public List<Lesion> readRecords() {
        List<Lesion> lesiones = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Lesion";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Lesion lesion = new Lesion();
                    lesion.setIdLesion(rs.getInt("id_lesion"));
                    lesion.setFechaInicio(rs.getString("fecha_inicio"));
                    lesion.setFechaFin(rs.getString("fecha_fin"));
                    lesion.setJugador(rs.getString("jugador"));

                    lesiones.add(lesion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lesiones;
    }
}
