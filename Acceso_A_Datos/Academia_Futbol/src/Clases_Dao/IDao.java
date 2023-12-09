import java.util.List;

// Interfaz genérica para operaciones básicas de acceso a datos (CRUD)
public interface IDao<T, V> {
    
    // Método para guardar un modelo en la base de datos
    boolean guardar_en_BD(T model);

    // Método para leer datos de la base de datos usando un identificador
    T leer_datos_BD(V id);

    // Método para actualizar datos en la base de datos usando un identificador
    boolean actualizar_datos_BD(T model, V id);

    // Método para borrar datos de la base de datos usando un identificador
    boolean borrar_datos_BD(V id);

    // Método para leer todos los registros de la base de datos
    List<T> readRecords();
}