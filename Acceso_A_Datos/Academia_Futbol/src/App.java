public class App {

    public static void main(String[] args) {
        // Crear un objeto Directivo con datos de ejemplo
        Directivo directivo = new Directivo();
        directivo.setId(1);
        directivo.setCargo("Presidente");

        // Crear un objeto de la clase DirectivoDAO
        DirectivoDAO directivoDAO = new DirectivoDAO();

        // Insertar el directivo en la base de datos
        boolean exito = directivoDAO.createRecord(directivo);

        // Verificar si la inserción fue exitosa
        if (exito) {
            System.out.println("Directivo insertado correctamente en la base de datos.");
        } else {
            System.out.println("Error al insertar el directivo en la base de datos.");
        }

        // Cerrar la conexión a la base de datos al finalizar
        Conexion_DB.cerrarConexion();
    }
}
