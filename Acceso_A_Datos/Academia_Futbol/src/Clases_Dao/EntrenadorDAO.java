import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDAO implements IDao<Entrenador, Integer> {

    private Connection conexion;
    private static final String ARCHIVO_ENTRENADORES = "listaEntrenadores.dat";
    public EntrenadorDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean guardar_en_BD(Entrenador entrenador) {
        try {
            String consulta = "INSERT INTO Entrenador (nombre, apellidos, partidos, meses_exp, id_equipo  ) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, entrenador.getNombre());
                ps.setString(2, entrenador.getApellidos());
                ps.setInt(3, entrenador.getPartidos());
                ps.setInt(4, entrenador.getMesesExp());
                ps.setInt(5, entrenador.getIdEquipo());
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    // Obtener el ID generado para el nuevo directivo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                        	entrenador.setIdEntrenador(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("No se pudo obtener el ID generado para el directivo.");
                        }
                    }
                }
                
                /*GUARADAR EN EL FICHERO DEL METODO QUE CONTIENE ESTA MISMA CLASE*/
                guardar_en_fichero_binario(entrenador);
                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Entrenador leer_datos_BD(Integer id) {
        try {
            String consulta = "SELECT * FROM Entrenador WHERE id_entrenador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Entrenador entrenador = new Entrenador();
                        entrenador.setIdEntrenador(rs.getInt("id_entrenador"));
                        entrenador.setNombre(rs.getString("nombre"));
                        entrenador.setApellidos(rs.getString("apellidos"));;
                        entrenador.setPartidos(rs.getInt("partidos"));
                        entrenador.setMesesExp(rs.getInt("meses_exp"));
                        entrenador.setIdEquipo(rs.getInt("id_equipo"));
                        
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
    public boolean actualizar_datos_BD(Entrenador entrenador, Integer id) {
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
    public boolean borrar_datos_BD(Integer id) {
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
                    entrenador.setApellidos(rs.getString("apellidos"));
                    entrenador.setPartidos(rs.getInt("partidos"));
                    entrenador.setMesesExp(rs.getInt("meses_exp"));
                    entrenador.setIdEquipo(rs.getInt("id_equipo"));

                    entrenadores.add(entrenador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entrenadores;
    }
    /*****************************************************************************************************/
    /*
     * metodo de condicion para cambiar el equipo al que va entrenar una persona si 
     * se ha modificado un equipo y se produce un intercambio de entrenadores.
     */
    public boolean actualizarEquipoEnEntrenador(int idEquipo, int idEntrenador) {
        try {
            String consulta = "UPDATE Entrenador SET id_equipo = ? WHERE id_entrenador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, idEquipo);
                ps.setInt(2, idEntrenador);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    /********************************* METODOS PARA TRABAJAR CON LOS FICHEROS ************************/
    public boolean guardar_en_fichero_binario(Entrenador entrenador) {
        List<Entrenador> listaEntrenadores = cargarArchivo(); // Cargar la lista existente
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ENTRENADORES))) {
            listaEntrenadores.add(entrenador); // Agregar el nuevo entrenador a la lista
            oos.writeObject(listaEntrenadores); // Escribir la lista actualizada en el archivo
            System.out.println("Entrenador guardado en archivo binario.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar el entrenador en archivo binario.");
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar la conexión aquí en el bloque porque los demas se crirran con el try pero este no se
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Entrenador> cargarArchivo() {
        List<Entrenador> entrenadores = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_ENTRENADORES))) {
            Object obj = ois.readObject();

            if (obj instanceof List) {
                entrenadores = (List<Entrenador>) obj;
              
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de entrenadores.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar la lista de entrenadores desde el archivo binario.");
            e.printStackTrace();
        }

        return entrenadores;
    }
}

