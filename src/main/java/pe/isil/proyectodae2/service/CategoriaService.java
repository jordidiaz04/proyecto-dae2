package pe.isil.proyectodae2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.repository.categoria.CategoriaRepository;
import pe.isil.proyectodae2.repository.categoria.JdbcCategoriaRepository;

import java.util.List;

@Service
public class CategoriaService implements GenericService<Categoria, Long> {
    @Autowired
    JdbcCategoriaRepository jdbcCategoriaRepository;

    @Override
    public void create(Categoria categoria) {
        jdbcCategoriaRepository.create(categoria);
    }

    @Override
    public void update(Categoria categoria) {
        jdbcCategoriaRepository.update(categoria);
    }

    @Override
    public void delete(Long id) {
        jdbcCategoriaRepository.delete(id);
    }

    @Override
    public List<Categoria> findAll() {
        return jdbcCategoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long aLong) {
        return jdbcCategoriaRepository.findById(aLong);
    }
}
