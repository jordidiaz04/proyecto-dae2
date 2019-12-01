package pe.isil.proyectodae2.repository.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcClienteRepository implements ClienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cliente> findAll() {
        final String sql = "select * from cliente";
        return jdbcTemplate.query(sql, JdbcClienteRepository::ClienteRowMapper);
    }

    @Override
    public Cliente findById(Long id) {
        final String sql = "select * from cliente where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcClienteRepository::ClienteRowMapper);
    }

    @Override
    public void create(Cliente cliente) {
        final String sql = "insert into cliente (dni, password, nombres, apellidos, email, telefono, direccion) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, cliente.getDni(), cliente.getPassword(),cliente.getNombres(),
                                 cliente.getApellidos(), cliente.getEmail(),cliente.getTelefono(), cliente.getDireccion());

    }

    @Override
    public void update(Cliente cliente) {
        final String sql = "update cliente set dni = ?, password = ?, nombres = ?, apellidos = ?, email = ?, telefono = ?," +
                "direccion = ? where id = ?";
        jdbcTemplate.update(sql, cliente.getDni(), cliente.getPassword(),cliente.getNombres(),
                cliente.getApellidos(), cliente.getEmail(),cliente.getTelefono(), cliente.getDireccion(), cliente.getId());

    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from cliente where id = ?";
        jdbcTemplate.update(sql, id);

    }

    private static Cliente ClienteRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsDni = resultSet.getString("dni");
        String rsNombres = resultSet.getString("nombres");
        String rsApellidos = resultSet.getString("apellidos");
        String rsEmail = resultSet.getString("email");
        String rsTelefono = resultSet.getString("telefono");
        String rsPassword = resultSet.getString("password");
        Boolean rsEstado = resultSet.getBoolean("estado");
        String rsDireccion = resultSet.getString("direccion");
        Boolean rsCuenta = resultSet.getBoolean("cuenta");
        Boolean rsCarrito = resultSet.getBoolean("carrito");
        return new Cliente(rsId, rsDni, rsNombres, rsApellidos, rsEmail, rsTelefono, rsPassword ,rsEstado, rsDireccion, rsCuenta, rsCarrito);
    }
}
