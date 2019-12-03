package pe.isil.proyectodae2.repository.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.repository.marca.MarcaRepository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMarcaRepository implements MarcaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Marca> findAll() {
        final String sql = "select * from marca";
        return jdbcTemplate.query(sql, JdbcMarcaRepository::MarcaRowMapper);
    }

    @Override
    public Marca findById(Long id) {
        final String sql = "select * from marca where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcMarcaRepository::MarcaRowMapper);
    }

    @Override
    public void create(Marca marca) {
        final String sql =
                "insert into marca " +
                        "(nombre, estado, descripcion, id_empresa) " +
                        "values (?,?,?,?)";
        jdbcTemplate.update(sql, marca.getNombre(), marca.isEstado(), marca.getDescripcion(), marca.getIdEmpresa());
    }

    @Override
    public void update(Marca marca) {
        final String sql = "update marca set " +
                "nombre = ?, estado = ?, descripcion = ?, id_empresa = ? " +
                "where id = ?";
        jdbcTemplate.update(sql, marca.getNombre(), marca.isEstado(), marca.getDescripcion(),
                marca.getIdEmpresa(), marca.getId());
    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from marca where id = ?";
        try {
            jdbcTemplate.update(sql, id);

        }catch (Exception e){
            //TODO: ATRAPAR ERRORES
        }
    }

    @Override
    public void add(Marca marca) {

    }

    private static Marca MarcaRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsNombre = resultSet.getString("nombre");
        Boolean rsEstado = resultSet.getBoolean("estado");
        String rsDescripcion = resultSet.getString("descripcion");
        Long rsid_empresa = resultSet.getLong("id_empresa");

        return new Marca(rsId, rsNombre, rsEstado, rsDescripcion, rsid_empresa);
    }
}
