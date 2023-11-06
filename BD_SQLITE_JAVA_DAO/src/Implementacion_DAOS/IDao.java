package Implementacion_DAOS;

import java.util.List;

public interface IDao<T, V> {
    boolean createRecord(T model);

    T readRecord(V id);

    boolean updateRecord(T model, V id);

    boolean deleteRecord(V id);

    List<T> readRecords();
}
