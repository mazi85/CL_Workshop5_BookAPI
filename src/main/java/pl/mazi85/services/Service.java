package pl.mazi85.services;

import java.util.List;

public interface Service<T> {

    List<T> readAll();
    public void create(T t);
    T read(long id);
    void update(T t);
    void delete(int id);
}
