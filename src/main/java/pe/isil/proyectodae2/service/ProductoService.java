package pe.isil.proyectodae2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.repository.producto.JdbcProductoRepository;
import pe.isil.proyectodae2.repository.producto.ProductoRepository;

import java.util.List;

@Service
public class ProductoService implements GenericService<Producto, Long>{
    @Autowired
    JdbcProductoRepository jdbcProductoRepository;

    @Override
    public void create(Producto producto) {
        jdbcProductoRepository.create(producto);
    }

    @Override
    public void update(Producto producto) {
        jdbcProductoRepository.update(producto);
    }

    @Override
    public void delete(Long id) {
        jdbcProductoRepository.delete(id);
    }

    @Override
    public List<Producto> findAll() {
        return jdbcProductoRepository.findAll();
    }

    @Override
    public Producto findById(Long aLong) {
        return jdbcProductoRepository.findById(aLong);
    }
}
