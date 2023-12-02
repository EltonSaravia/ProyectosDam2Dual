import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDAO implements IDao<Entrenador, Integer> {

    private Connection conexion;

    public EntrenadorDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean createRecord(Entrenador entrenador) {
        try {
            String consulta = "INSERT INTO Entrenador (nombre, partidos, meses_exp) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, entrenador.getNombre());
                ps.setInt(2, entrenador.getPartidos());
                ps.setInt(3, entrenador.getMesesExp());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Entrenador readRecord(Integer id) {
        try {
            String consulta = "SELECT * FROM Entrenador WHERE id_entrenador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Entrenador entrenador = new Entrenador();
                        entrenador.setIdEntrenador(rs.getInt("id_entrenador"));
                        entrenador.setNombre(rs.getString("nombre"));
                        entrenador.setPartidos(rs.getInt("partidos"));
                        entrenador.setMesesExp(rs.getInt("meses_exp"));
                        return entrenador;
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
    public boolean updateRecord(Entrenador entrenador, Integer id) {
        try {
            String consulta = "UPDATE Entrenador SET nombre = ?, partidos = ?, meses_exp = ? WHERE id_entrenador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, entrenador.getNombre());
                ps.setInt(2, entrenador.getPartidos());
                ps.setInt(3, entrenador.getMesesExp());
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
            String consulta = "DELETE FROM Entrenador WHERE id_entrenador = ?";
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
    public List<Entrenador> readRecords() {
        List<Entrenador> entrenadores = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Entrenador";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Entrenador entrenador = new Entrenador();
                    entrenador.setIdEntrenador(rs.getInt("id_entrenador"));
                    entrenador.setNombre(rs.getString("nombre"));
                    entrenador.setPartidos(rs.getInt("partidos"));
                    entrenador.setMesesExp(rs.getInt("meses_exp"));

                    entrenadores.add(entrenador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entrenadores;
    }
}

