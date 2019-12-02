package pe.isil.proyectodae2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.repository.marca.JdbcMarcaRepository;

import java.util.List;

@Service
public class MarcaService implements GenericService<Marca, Long>{
    @Autowired
    JdbcMarcaRepository jdbcMarcaRepository;

    @Override
    public void create(Marca marca) {
        jdbcMarcaRepository.create(marca);
    }

    @Override
    public void update(Marca marca) {
        jdbcMarcaRepository.update(marca);
    }

    @Override
    public void delete(Long id) {
        jdbcMarcaRepository.delete(id);
    }

    @Override
    public List<Marca> findAll() {
        return jdbcMarcaRepository.findAll();
    }

    @Override
    public Marca findById(Long aLong) {
        return jdbcMarcaRepository.findById(aLong);
    }
}
