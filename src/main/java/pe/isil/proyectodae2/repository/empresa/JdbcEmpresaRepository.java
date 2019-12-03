package pe.isil.proyectodae2.repository.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.proyectodae2.model.Empresa;
import pe.isil.proyectodae2.repository.empresa.EmpresaRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcEmpresaRepository implements EmpresaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Empresa> findAll() {
        final String sql = "select * from empresa";
        return jdbcTemplate.query(sql, JdbcEmpresaRepository::EmpresaRowMapper);
    }

    @Override
    public Empresa findById(Long id) {
        final String sql = "select * from empresa where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcEmpresaRepository::EmpresaRowMapper);
    }

    @Override
    public void create(Empresa empresa) {
        final String sql =
                "insert into empresa " +
                        "(nombre, estado) " +
                        "values (?,?)";
        jdbcTemplate.update(sql, empresa.getNombre(), empresa.isEstado());
    }

    @Override
    public void update(Empresa empresa) {
        final String sql = "update empresa set " +
                "nombre = ?, estado = ? " +
                "where id = ?";
        jdbcTemplate.update(sql, empresa.getNombre(), empresa.isEstado(), empresa.getId());
    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from empresa where id = ?";
        try {
            jdbcTemplate.update(sql, id);

        }catch (Exception e){
            //TODO: ATRAPAR ERRORES
        }
    }

    @Override
    public void add(Empresa empresa) {

    }

    private static Empresa EmpresaRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsNombre = resultSet.getString("nombre");
        Boolean rsEstado = resultSet.getBoolean("estado");

        return new Empresa(rsId, rsNombre, rsEstado);
    }
}
