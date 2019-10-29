package pe.isil.proyectodae2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsuarioJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario login(Usuario usuario){
        final String sql = "select * from usuario where dni = ? and password = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{usuario.dni, usuario.password}, UsuarioJdbc::UsuarioRowMapper);
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
