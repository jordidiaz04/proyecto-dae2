package pe.isil.proyectodae2.repository.marca;

import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface MarcaRepository extends BaseRepository<Marca, Long> {
}
