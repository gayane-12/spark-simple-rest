package api.services;


import java.util.List;

public interface BaseService<T> {
    List<T> getAll();
    T getById(String id);
    T create(T object);
    T delete(String id);
    T update(String id, T object);
}
