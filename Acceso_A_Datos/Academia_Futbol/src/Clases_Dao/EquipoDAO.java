/**
 * 
 */

/**
 * @author Elton Jesús Saravia Ibarra	
 *
 * ryuzaki12elton@gmail.com
 */
import java.io.EOFException;
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

public class EquipoDAO implements IDao<Equipo, Integer> {
    private Connection conexion;
    private static final String ARCHIVO_EQUIPOS = "listaEquipos.dat";
    public EquipoDAO() {
        this.conexion = Conexion_DB.obtenerConexion();
    }

    @Override
    public boolean guardar_en_BD(Equipo equipo) {
        try {
            String consulta = "INSERT INTO Equipo (estadio, entrenador, categoria) VALUES ( ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                
                ps.setString(1, equipo.getEstadio());
                ps.setLong(2, equipo.getEntrenador());
                ps.setString(3, equipo.getCategoria());
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    // Obtener el ID generado para el nuevo directivo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                        	equipo.setCodEquipo(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("No se pudo obtener el ID generado para el directivo.");
                        }
                    }
                }
                guardarEnFicheroBinario(equipo);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Equipo leer_datos_BD(Integer id) {
        try {
            String consulta = "SELECT * FROM Equipo WHERE cod_equipo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Equipo equipo = new Equipo();
                        equipo.setCodEquipo(rs.getInt("cod_equipo"));
                        equipo.setEstadio(rs.getString("estadio"));
                        equipo.setEntrenador(rs.getInt("entrenador"));
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
    public boolean actualizar_datos_BD(Equipo equipo, Integer id) {
        try {
            String consulta = "UPDATE Equipo SET estadio = ?, entrenador = ?, categoria = ? WHERE cod_equipo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, equipo.getEstadio());
                ps.setInt(2, equipo.getEntrenador());
                ps.setString(3, equipo.getCategoria());
                ps.setInt(4, id);
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    // Obtener el ID generado para el nuevo directivo
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                        	equipo.setCodEquipo(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("No se pudo obtener el ID generado para el directivo.");
                        }
                    }
                }
               
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
                    equipo.setEntrenador(rs.getInt("entrenador"));
                    equipo.setCategoria(rs.getString("categoria"));
                    

                    equipos.add(equipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipos;
    }
    
    
    
    
    /*****************************************************************************************************/
   /* metodo postcondicion  al crear un entrenador nuevo se le debe asignar un equipo ya creado
    * y se debe actualizar los datos de dicho equipo*/
    public boolean actualizarEntrenadorEnEquipo(int idEquipo, int idEntrenador) {
        try {
            String consulta = "UPDATE Equipo SET entrenador = ? WHERE cod_equipo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setInt(1, idEntrenador);
                ps.setInt(2, idEquipo);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    ////////////////// este lo he creado porque he estado realizndo pruebas al borrar un entrenador he decidido cambiar los ids a String si me da tiempo//////////////
    public boolean actualizarEntrenadorEnEquipo(int idEquipo, String nuevoEntrenador) {
        try {
            String consulta = "UPDATE Equipo SET id_entrenador = ? WHERE cod_equipo = ?";
            try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
                ps.setString(1, nuevoEntrenador);
                ps.setInt(2, idEquipo);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
        
    }
    
    
    /*******************************************************paraficheros*****************************************/

    public boolean guardarEnFicheroBinario(Equipo equipo) {
        List<Equipo> listaEquipos = cargarArchivo(); // Cargar la lista existente

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EQUIPOS))) {
            listaEquipos.add(equipo); // Agregar el nuevo equipo a la lista
            oos.writeObject(listaEquipos); // Escribir la lista actualizada en el archivo
            System.out.println("Equipo guardado en archivo binario.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar el equipo en archivo binario.");
            e.printStackTrace();
            return false;
        }
    }

    public List<Equipo> cargarArchivo() {
        List<Equipo> equipos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_EQUIPOS))) {
            Object obj = ois.readObject();

            if (obj instanceof List) {
                equipos = (List<Equipo>) obj;
               
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de equipos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar la lista de equipos desde el archivo binario.");
            e.printStackTrace();
        }

        return equipos;
    }

}

