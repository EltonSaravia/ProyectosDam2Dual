/**
 * 
 */

/**
 * @author Elton Jesús Saravia Ibarra	
 *
 * ryuzaki12elton@gmail.com
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO implements IDao<Equipo, Integer> {
    private Connection conexion;

    public EquipoDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean createRecord(Equipo equipo) {
        try {
            String consulta = "INSERT INTO Equipo (cod_equipo, estadio, entrenador, categoria) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, equipo.getCodEquipo());
                ps.setString(2, equipo.getEstadio());
                ps.setString(3, equipo.getEntrenador());
                ps.setString(4, equipo.getCategoria());

                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Equipo readRecord(Integer id) {
        try {
            String consulta = "SELECT * FROM Equipo WHERE cod_equipo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Equipo equipo = new Equipo();
                        equipo.setCodEquipo(rs.getInt("cod_equipo"));
                        equipo.setEstadio(rs.getString("estadio"));
                        equipo.setEntrenador(rs.getString("entrenador"));
                        equipo.setCategoria(rs.getString("categoria"));
                        return equipo;
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
    public boolean updateRecord(Equipo equipo, Integer id) {
        try {
            String consulta = "UPDATE Equipo SET estadio = ?, entrenador = ?, categoria = ? WHERE cod_equipo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, equipo.getEstadio());
                ps.setString(2, equipo.getEntrenador());
                ps.setString(3, equipo.getCategoria());
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
            String consulta = "DELETE FROM Equipo WHERE cod_equipo = ?";
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
    public List<Equipo> readRecords() {
        List<Equipo> equipos = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Equipo";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setCodEquipo(rs.getInt("cod_equipo"));
                    equipo.setEstadio(rs.getString("estadio"));
                    equipo.setEntrenador(rs.getString("entrenador"));
                    equipo.setCategoria(rs.getString("categoria"));

                    equipos.add(equipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipos;
    }
}

