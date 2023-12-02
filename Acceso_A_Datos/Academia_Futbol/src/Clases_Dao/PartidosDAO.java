import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidosDAO implements IDao<Partidos, Integer> {

    private Connection conexion;

    public PartidosDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean createRecord(Partidos partido) {
        try {
            String consulta = "INSERT INTO Partidos (equipo_local, equipo_visitante) VALUES (?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, partido.getEquipoLocal());
                ps.setString(2, partido.getEquipoVisitante());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Partidos readRecord(Integer id) {
        try {
            String consulta = "SELECT * FROM Partidos WHERE id_partido = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Partidos partido = new Partidos();
                        partido.setIdPartido(rs.getInt("id_partido"));
                        partido.setEquipoLocal(rs.getString("equipo_local"));
                        partido.setEquipoVisitante(rs.getString("equipo_visitante"));
                        return partido;
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
    public boolean updateRecord(Partidos partido, Integer id) {
        try {
            String consulta = "UPDATE Partidos SET equipo_local = ?, equipo_visitante = ? WHERE id_partido = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, partido.getEquipoLocal());
                ps.setString(2, partido.getEquipoVisitante());
                ps.setInt(3, id);
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
            String consulta = "DELETE FROM Partidos WHERE id_partido = ?";
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
    public List<Partidos> readRecords() {
        List<Partidos> partidosList = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Partidos";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Partidos partido = new Partidos();
                    partido.setIdPartido(rs.getInt("id_partido"));
                    partido.setEquipoLocal(rs.getString("equipo_local"));
                    partido.setEquipoVisitante(rs.getString("equipo_visitante"));

                    partidosList.add(partido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partidosList;
    }
}

