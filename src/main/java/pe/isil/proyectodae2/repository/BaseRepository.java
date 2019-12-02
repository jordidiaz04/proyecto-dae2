package pe.isil.proyectodae2.repository;

import java.util.List;

public interface BaseRepository<X, Y> {

    public void create(X x);
    public void update(X x);
    public void delete(Y y);
    public void add(X x);

    public X findById(Y y);
    public List<X> findAll();

}
