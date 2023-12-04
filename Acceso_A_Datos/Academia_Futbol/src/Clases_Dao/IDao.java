import java.util.List;

public interface IDao<T, V> {
    boolean guardarJugadorBD(T model);

    T leerJugadorBD(V id);

    boolean actualizarJugadorBD(T model, V id);

    boolean borrarJugadorBD(V id);

    List<T> readRecords();
}