package pe.isil.proyectodae2.repository;

import java.util.List;

public interface BaseRepository<T, K> {
    List<T> findAll();
    T findById(K k);
    void create(T t);
    void update(T t);
    void delete(K k);
}