import java.util.List;

public interface IDao<T, V> {
    boolean guardar_en_BD(T model);

    T leer_datos_BD(V id);

    boolean actualizar_datos_BD(T model, V id);

    boolean borrar_datos_BD(V id);

    List<T> readRecords();
}