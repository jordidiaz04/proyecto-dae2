package pe.isil.proyectodae2.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long> {
}
