package pe.isil.proyectodae2.repository.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCategoriaRepository implements CategoriaRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Categoria> findAll() {
        final String sql = "select * from categoria";
        return jdbcTemplate.query(sql, JdbcCategoriaRepository::CategoriaRowMapper);
    }

    @Override
    public Categoria findById(Long id) {
        final String sql = "select * from categoria where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcCategoriaRepository::CategoriaRowMapper);
    }

    @Override
    public void create(Categoria categoria) {
        final String sql = "insert into categoria (nombre, descripcion, estado) values (?,?,?)";
        jdbcTemplate.update(sql, categoria.getNombre(),categoria.getDescripcion(), categoria.isEstado());

    }

    @Override
    public void update(Categoria categoria) {
        final String sql = "update categoria set nombre = ?, descripcion = ?, estado = ? where id = ?";
        jdbcTemplate.update(sql, categoria.getNombre(), categoria.getDescripcion(), categoria.isEstado(), categoria.getId());
    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from categoria where id = ?";
        try {
            jdbcTemplate.update(sql, id);

        }catch (Exception e){
            //TODO: ATRAPAR ERRORES
        }
    }

    private static Categoria CategoriaRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsNombre = resultSet.getString("nombre");
        String rsDescripcion = resultSet.getString("descripcion");
        Boolean rsEstado = resultSet.getBoolean("estado");
        return new Categoria(rsId, rsNombre, rsDescripcion, rsEstado);
    }
}
