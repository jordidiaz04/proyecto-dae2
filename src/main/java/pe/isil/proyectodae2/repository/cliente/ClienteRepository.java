package pe.isil.proyectodae2.repository.cliente;

import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Cliente;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
