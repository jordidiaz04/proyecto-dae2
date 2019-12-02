package pe.isil.proyectodae2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JdbcClienteRepository implements ClienteRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Cliente cliente) {
        final  String sql = "insert into cliente(dni, nombres, apellidos, email, telefono, password, estado, direccion ) values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, cliente.getDni(), cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getTelefono(), cliente.getPassword(), cliente.getEstado(), cliente.getEstado());

    }

    @Override
    public void update(Cliente cliente) {
        final String sql = "update cliente set dni = ?, nombres = ?, apellidos = ?, email = ?, telefono = ?, password = ?, estado = ?, direccion = ? where id = ?";
        jdbcTemplate.update(sql, cliente.getDni(), cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getTelefono(), cliente.getPassword(), cliente.getEstado(), cliente.getEstado(), cliente.getId());
    }

    @Override
    public void delete(Long id) {
        final  String sql = "delete cliente where id = ?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public void add(Cliente cliente) {

    }

    @Override
    public Cliente findById(Long id) {
        final String sql = "select * from cliente where id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcClienteRepository::ClienteRowMapper);
    }

    private static Cliente ClienteRowMapper(ResultSet resultSet, int i)
                throws SQLException{
                    long id = resultSet.getLong("id");
                    String dni = resultSet.getString("dni");
                    String nombres = resultSet.getString("nombres");
                    String apellidos = resultSet.getString("apellidos");
                    String email = resultSet.getString("email");
                    String telefono = resultSet.getString("telefono");
                    String password = resultSet.getString("password");
                    String estado = resultSet.getString("estado");
                    String direccion = resultSet.getString("direccion");

                    return new Cliente(id, dni, nombres, apellidos, email, telefono, password, estado, direccion);

    }

    @Override
    public List<Cliente> findAll() {
        final String sql = "select * from cliente";
        return jdbcTemplate.query(sql, JdbcClienteRepository::ClienteRowMapper);
    }
}
