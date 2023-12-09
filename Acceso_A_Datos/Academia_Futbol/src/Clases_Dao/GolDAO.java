import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GolDAO implements IDao<Gol, Integer> {

    private Connection conexion;

    public GolDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean guardar_en_BD(Gol gol) {
        try {
            String consulta = "INSERT INTO Gol (jugador, dorsal, equipo, partido, min) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, gol.getJugador());
                ps.setInt(2, gol.getDorsal());
                ps.setString(3, gol.getEquipo());
                ps.setInt(4, gol.getPartido());
                ps.setInt(5, gol.getMin());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Gol leer_datos_BD(Integer id) {
        try {
            String consulta = "SELECT * FROM Gol WHERE id_gol = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Gol gol = new Gol();
                        gol.setIdGol(rs.getInt("id_gol"));
                        gol.setJugador(rs.getString("jugador"));
                        gol.setDorsal(rs.getInt("dorsal"));
                        gol.setEquipo(rs.getString("equipo"));
                        gol.setPartido(rs.getInt("partido"));
                        gol.setMin(rs.getInt("min"));
                        return gol;
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
    public boolean actualizar_datos_BD(Gol gol, Integer id) {
        try {
            String consulta = "UPDATE Gol SET jugador = ?, dorsal = ?, equipo = ?, partido = ?, min = ? WHERE id_gol = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, gol.getJugador());
                ps.setInt(2, gol.getDorsal());
                ps.setString(3, gol.getEquipo());
                ps.setInt(4, gol.getPartido());
                ps.setInt(5, gol.getMin());
                ps.setInt(6, id);
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
            String consulta = "DELETE FROM Gol WHERE id_gol = ?";
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
    public List<Gol> readRecords() {
        List<Gol> goles = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Gol";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Gol gol = new Gol();
                    gol.setIdGol(rs.getInt("id_gol"));
                    gol.setJugador(rs.getString("jugador"));
                    gol.setDorsal(rs.getInt("dorsal"));
                    gol.setEquipo(rs.getString("equipo"));
                    gol.setPartido(rs.getInt("partido"));
                    gol.setMin(rs.getInt("min"));

                    goles.add(gol);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goles;
    }
}
