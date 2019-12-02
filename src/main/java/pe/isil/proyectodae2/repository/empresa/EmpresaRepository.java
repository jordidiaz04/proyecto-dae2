package pe.isil.proyectodae2.repository.empresa;

import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Empresa;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface EmpresaRepository extends BaseRepository<Empresa, Long> {
}
