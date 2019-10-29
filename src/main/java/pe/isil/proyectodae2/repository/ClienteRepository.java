package pe.isil.proyectodae2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Cliente;
import pe.isil.proyectodae2.model.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
