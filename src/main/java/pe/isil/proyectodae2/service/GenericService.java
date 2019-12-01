package pe.isil.proyectodae2.service;

import java.util.List;

public interface GenericService<T, K> {
    void create(T t);
    void update(T t);
    void delete(Long id);
    List<T> findAll();
    T findById(K k);

}
