package pe.isil.proyectodae2.repository.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {
}
