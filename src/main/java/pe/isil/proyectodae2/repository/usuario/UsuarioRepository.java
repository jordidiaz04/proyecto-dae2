package pe.isil.proyectodae2.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Usuario;
import pe.isil.proyectodae2.repository.BaseRepository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
}
