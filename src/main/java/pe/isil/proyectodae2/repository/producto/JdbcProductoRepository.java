package pe.isil.proyectodae2.repository.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.model.Producto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductoRepository implements ProductoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> findAll() {
        final String sql = "select * from producto";
        return jdbcTemplate.query(sql, JdbcProductoRepository::ProductoRowMapper);
    }

    @Override
    public Producto findById(Long id) {
        final String sql = "select * from producto where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcProductoRepository::ProductoRowMapper);
    }

    @Override
    public void create(Producto producto) {
        final String sql =
                "insert into producto " +
                        "(codigo, nombre, precio, descripcion, stock, estado, idCategoria, idMarca) " +
                        "values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getDescripcion(),
                producto.getStock(), producto.isEstado(),producto.getIdCategoria(), producto.getIdMarca());
    }

    @Override
    public void update(Producto producto) {
        final String sql = "update categoria set " +
                "codigo = ?, nombre = ?, precio = ?, descripcion = ?, stock = ?, estado = ?, idCategoria = ?, idMarca = ?" +
                "where id = ?";
        jdbcTemplate.update(sql, producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getDescripcion(),
                producto.getStock(), producto.isEstado(),producto.getIdCategoria(), producto.getIdMarca());
    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from producto where id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static Producto ProductoRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsCodigo = resultSet.getString("codigo");
        String rsNombre = resultSet.getString("nombre");
        BigDecimal rsPrecio = resultSet.getBigDecimal("precio");
        String rsDescripcion = resultSet.getString("descripcion");
        Long rsStock = resultSet.getLong("stock");
        Boolean rsEstado = resultSet.getBoolean("estado");
        Long rsIdCategoria = resultSet.getLong("idCategoria");
        Long rsidMarca = resultSet.getLong("idMarca");

        return new Producto(rsId, rsCodigo, rsNombre, rsPrecio, rsDescripcion, rsStock, rsEstado, rsIdCategoria, rsidMarca);
    }
}
