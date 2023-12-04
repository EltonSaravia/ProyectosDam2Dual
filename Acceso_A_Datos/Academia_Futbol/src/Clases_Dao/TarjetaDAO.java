import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO implements IDao<Tarjeta, Integer> {

    private Connection conexion;

    public TarjetaDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean guardarJugadorBD(Tarjeta tarjeta) {
        try {
            String consulta = "INSERT INTO Tarjeta (roja, amarilla, jugador) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setBoolean(1, tarjeta.isRoja());
                ps.setBoolean(2, tarjeta.isAmarilla());
                ps.setString(3, tarjeta.getJugador());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tarjeta leerJugadorBD(Integer id) {
        try {
            String consulta = "SELECT * FROM Tarjeta WHERE id_tarjeta = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Tarjeta tarjeta = new Tarjeta();
                        tarjeta.setIdTarjeta(rs.getInt("id_tarjeta"));
                        tarjeta.setRoja(rs.getBoolean("roja"));
                        tarjeta.setAmarilla(rs.getBoolean("amarilla"));
                        tarjeta.setJugador(rs.getString("jugador"));
                        return tarjeta;
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
    public boolean actualizarJugadorBD(Tarjeta tarjeta, Integer id) {
        try {
            String consulta = "UPDATE Tarjeta SET roja = ?, amarilla = ?, jugador = ? WHERE id_tarjeta = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setBoolean(1, tarjeta.isRoja());
                ps.setBoolean(2, tarjeta.isAmarilla());
                ps.setString(3, tarjeta.getJugador());
                ps.setInt(4, id);
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
            String consulta = "DELETE FROM Tarjeta WHERE id_tarjeta = ?";
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
    public List<Tarjeta> readRecords() {
        List<Tarjeta> tarjetas = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Tarjeta";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Tarjeta tarjeta = new Tarjeta();
                    tarjeta.setIdTarjeta(rs.getInt("id_tarjeta"));
                    tarjeta.setRoja(rs.getBoolean("roja"));
                    tarjeta.setAmarilla(rs.getBoolean("amarilla"));
                    tarjeta.setJugador(rs.getString("jugador"));

                    tarjetas.add(tarjeta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarjetas;
    }
}
