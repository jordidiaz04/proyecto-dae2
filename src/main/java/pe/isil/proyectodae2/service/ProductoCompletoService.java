package pe.isil.proyectodae2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.model.ProductoCompleto;
import pe.isil.proyectodae2.repository.producto.JdbcProductoCompletoRepository;
import pe.isil.proyectodae2.repository.producto.JdbcProductoRepository;

import java.util.List;

@Service
public class ProductoCompletoService{
    @Autowired
    JdbcProductoCompletoRepository jdbcProductoRepository;

    public List<ProductoCompleto> findAll() {
        return jdbcProductoRepository.findAll();
    }

    public ProductoCompleto findById(Long aLong) {
        return jdbcProductoRepository.findById(aLong);
    }
}
