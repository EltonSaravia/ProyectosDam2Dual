import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO implements IDao<Jugador, Integer> {
    private Connection conexion;

    public JugadorDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean createRecord(Jugador jugador) {
        try {
        	
        	//Consulta para sacar todos los datos
            String consulta = "INSERT INTO Jugador (nombre, apellidos, edad, dorsal, posicion, " +
                    "partidos_jugados, min_acumulados, amarillas, rojas, lesionado, " +
                    "partidos_sancionado, categoria, equipoNombre)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, jugador.getNombre());
                ps.setString(2, jugador.getApellidos());
                ps.setInt(3, jugador.getEdad());
                ps.setInt(4, jugador.getDorsal());
                ps.setString(5, jugador.getPosicion());
                ps.setInt(6, jugador.getPartidosJugados());
                ps.setInt(7, jugador.getMinAcumulados());
                ps.setInt(8, jugador.getAmarillas());
                ps.setInt(9, jugador.getRojas());
                ps.setBoolean(10, jugador.isLesionado());
                ps.setInt(11, jugador.getPartidosSancionado());
                ps.setString(12, jugador.getCategoria());
                ps.setString(13, jugador.getEquipoNombre());

                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Jugador readRecord(Integer id) {
        try {
            String consulta = "SELECT * FROM Jugador WHERE id_jugador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Jugador jugador = new Jugador();
                        jugador.setIdJugador(rs.getInt("id_jugador"));
                        jugador.setNombre(rs.getString("nombre"));
                        jugador.setApellidos(rs.getString("apellidos"));
                        jugador.setEdad(rs.getInt("edad"));
                        jugador.setDorsal(rs.getInt("dorsal"));
                        jugador.setPosicion(rs.getString("posicion"));
                        jugador.setPartidosJugados(rs.getInt("partidos_jugados"));
                        jugador.setMinAcumulados(rs.getInt("min_acumulados"));
                        jugador.setAmarillas(rs.getInt("amarillas"));
                        jugador.setRojas(rs.getInt("rojas"));
                        jugador.setLesionado(rs.getBoolean("lesionado"));
                        jugador.setPartidosSancionado(rs.getInt("partidos_sancionado"));
                        jugador.setCategoria(rs.getString("categoria"));
                        jugador.setEquipoNombre(rs.getString("equipoNombre"));
                        return jugador;
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
    public boolean updateRecord(Jugador jugador, Integer id) {
        try {
            String consulta = "UPDATE Jugador SET nombre = ?, apellidos = ?, edad = ?, dorsal = ?, " +
                    "posicion = ?, partidos_jugados = ?, min_acumulados = ?, amarillas = ?, rojas = ?, " +
                    "lesionado = ?, partidos_sancionado = ?, categoria = ?, equipoNombre = ? WHERE id_jugador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, jugador.getNombre());
                ps.setString(2, jugador.getApellidos());
                ps.setInt(3, jugador.getEdad());
                ps.setInt(4, jugador.getDorsal());
                ps.setString(5, jugador.getPosicion());
                ps.setInt(6, jugador.getPartidosJugados());
                ps.setInt(7, jugador.getMinAcumulados());
                ps.setInt(8, jugador.getAmarillas());
                ps.setInt(9, jugador.getRojas());
                ps.setBoolean(10, jugador.isLesionado());
                ps.setInt(11, jugador.getPartidosSancionado());
                ps.setString(12, jugador.getCategoria());
                ps.setString(13, jugador.getEquipoNombre());
                ps.setInt(14, id);

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
            String consulta = "DELETE FROM Jugador WHERE id_jugador = ?";
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
    public List<Jugador> readRecords() {
        List<Jugador> jugadores = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM Jugador";
            try (PreparedStatement ps = conexion.prepareStatement(consulta);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Jugador jugador = new Jugador();
                    jugador.setIdJugador(rs.getInt("id_jugador"));
                    jugador.setNombre(rs.getString("nombre"));
                    jugador.setApellidos(rs.getString("apellidos"));
                    jugador.setEdad(rs.getInt("edad"));
                    jugador.setDorsal(rs.getInt("dorsal"));
                    jugador.setPosicion(rs.getString("posicion"));
                    jugador.setPartidosJugados(rs.getInt("partidos_jugados"));
                    jugador.setMinAcumulados(rs.getInt("min_acumulados"));
                    jugador.setAmarillas(rs.getInt("amarillas"));
                    jugador.setRojas(rs.getInt("rojas"));
                    jugador.setLesionado(rs.getBoolean("lesionado"));
                    jugador.setPartidosSancionado(rs.getInt("partidos_sancionado"));
                    jugador.setCategoria(rs.getString("categoria"));
                    jugador.setEquipoNombre(rs.getString("equipoNombre"));

                    jugadores.add(jugador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jugadores;
  
}
    }