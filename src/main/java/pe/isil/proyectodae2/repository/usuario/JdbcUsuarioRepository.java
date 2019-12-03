package pe.isil.proyectodae2.repository.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.jdbc.UsuarioJdbc;
import pe.isil.proyectodae2.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUsuarioRepository implements UsuarioRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Usuario> findAll() {
        final String sql = "select * from usuario";
        return jdbcTemplate.query(sql, JdbcUsuarioRepository::UsuarioRowMapper);
    }

    @Override
    public Usuario findById(Long id) {
        final String sql = "select * from usuario where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcUsuarioRepository::UsuarioRowMapper);
    }

    @Override
    public void create(Usuario usuario) {
        final String sql = "insert into usuario (dni, password, nombres, apellidos, email, telefono, estado) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, usuario.getDni(), usuario.getPassword(),usuario.getNombres(), usuario.getApellidos(),
                usuario.getEmail(), usuario.getTelefono(), usuario.getEstado());
    }

    @Override
    public void update(Usuario usuario) {
        final String sql = "update usuario set dni = ?, password = ?, nombres = ?, apellidos = ?, " +
                "email = ?, telefono = ? where id = ?";
        jdbcTemplate.update(sql, usuario.getDni(), usuario.getPassword(),usuario.getNombres(), usuario.getApellidos(),
                usuario.getEmail(), usuario.getTelefono(), usuario.getId());
    }

    @Override
    public void delete(Long id) {
            final String sql = "delete from usuario where id = ?";
            jdbcTemplate.update(sql, id);

    }

    @Override
    public void add(Usuario usuario) {

    }

    public Usuario login(Usuario usuario){
        final String sql = "select * from usuario where dni = ? and password = ?";
        Usuario obj = null;
        try {
            obj = jdbcTemplate.queryForObject(sql, new Object[]{usuario.dni, usuario.password}, JdbcUsuarioRepository::UsuarioRowMapper);
        }
        catch (Exception ex){
            obj = null;
        }
        return obj;
    }

    private static Usuario UsuarioRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String dni = resultSet.getString("dni");
        String nombres = resultSet.getString("nombres");
        String apellidos = resultSet.getString("apellidos");
        String email = resultSet.getString("email");
        String telefono = resultSet.getString("telefono");
        String password = resultSet.getString("password");
        Boolean estado = resultSet.getBoolean("estado");
        return new Usuario(id, dni, nombres, apellidos, email, telefono, password, estado);
    }
}
