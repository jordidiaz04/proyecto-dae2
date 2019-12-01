package pe.isil.proyectodae2.repository.producto;

import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.model.ProductoCompleto;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface ProductoCompletoRepository extends BaseRepository<ProductoCompleto, Long> {
}
