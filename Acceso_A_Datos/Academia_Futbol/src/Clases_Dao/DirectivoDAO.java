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
    public boolean createRecord(Directivo directivo) {
        // Implementar la lógica para insertar un nuevo directivo en la base de datos
        return false;
    }

    @Override
    public Directivo readRecord(Integer id) {
        // Implementar la lógica para leer un directivo de la base de datos por su ID
        return null;
    }

    @Override
    public boolean updateRecord(Directivo directivo, Integer id) {
        // Implementar la lógica para actualizar un directivo en la base de datos
        return false;
    }

    @Override
    public boolean deleteRecord(Integer id) {
        // Implementar la lógica para eliminar un directivo de la base de datos por su ID
        return false;
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
