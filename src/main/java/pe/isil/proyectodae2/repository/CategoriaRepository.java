package pe.isil.proyectodae2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.model.Producto;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
