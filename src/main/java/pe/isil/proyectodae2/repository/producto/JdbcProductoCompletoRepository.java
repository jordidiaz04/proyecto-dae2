package pe.isil.proyectodae2.repository.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.ProductoCompleto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductoCompletoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductoCompleto> findAll() {
        final String sql =
                "select \n" +
                        "p.id,\n" +
                        "p.codigo,\n" +
                        "p.nombre,\n" +
                        "p.estado,\n" +
                        "p.descripcion,\n" +
                        "p.precio,\n" +
                        "p.stock,\n" +
                        "c.id [categoriaId],\n" +
                        "c.nombre [categoriaNombre],\n" +
                        "m.id [marcaId],\n" +
                        "m.nombre [marcaNombre],\n" +
                        "e.id [empresaId],\n" +
                        "e.nombre [empresaNombre]\n" +
                        "from producto p\n" +
                        "inner join categoria c on c.id = p.id_categoria\n" +
                        "inner join marca m on m.id = p.id_marca\n" +
                        "inner join empresa e on e.id = m.id_empresa";
        return jdbcTemplate.query(sql, JdbcProductoCompletoRepository::ProductoCompletoRowMapper);
    }

    public ProductoCompleto findById(Long id) {
        final String sql =
                "select \n" +
                        "p.id,\n" +
                        "p.codigo,\n" +
                        "p.nombre,\n" +
                        "p.estado,\n" +
                        "p.descripcion,\n" +
                        "p.precio,\n" +
                        "p.stock,\n" +
                        "c.id [categoriaId],\n" +
                        "c.nombre [categoriaNombre],\n" +
                        "m.id [marcaId],\n" +
                        "m.nombre [marcaNombre],\n" +
                        "e.id [empresaId],\n" +
                        "e.nombre [empresaNombre]\n" +
                        "from producto p\n" +
                        "inner join categoria c on c.id = p.id_categoria\n" +
                        "inner join marca m on m.id = p.id_marca\n" +
                        "inner join empresa e on e.id = m.id_marca\n" +
                        "where p.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcProductoCompletoRepository::ProductoCompletoRowMapper);
    }

    private static ProductoCompleto ProductoCompletoRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsCodigo = resultSet.getString("codigo");
        String rsNombre = resultSet.getString("nombre");
        BigDecimal rsPrecio = resultSet.getBigDecimal("precio");
        String rsDescripcion = resultSet.getString("descripcion");
        Long rsStock = resultSet.getLong("stock");
        Boolean rsEstado = resultSet.getBoolean("estado");
        Long rsIdCategoria = resultSet.getLong("categoriaId");
        Long rsidMarca = resultSet.getLong("marcaId");
        Long rsidEmpresa = resultSet.getLong("empresaId");
        String rsCategoriaNombre = resultSet.getString("categoriaNombre");
        String rsMarcaNombre = resultSet.getString("marcaNombre");
        String rsEmpresaNombre = resultSet.getString("empresaNombre");

        return new ProductoCompleto(rsId, rsCodigo, rsNombre, rsPrecio, rsDescripcion, rsStock, rsEstado, rsIdCategoria,
                rsCategoriaNombre, rsidMarca, rsMarcaNombre, rsidEmpresa, rsEmpresaNombre);
    }
}
