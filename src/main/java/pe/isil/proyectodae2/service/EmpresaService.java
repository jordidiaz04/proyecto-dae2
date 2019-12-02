package pe.isil.proyectodae2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectodae2.model.Empresa;
import pe.isil.proyectodae2.repository.empresa.JdbcEmpresaRepository;

import java.util.List;

@Service
public class EmpresaService implements GenericService<Empresa, Long>{
    @Autowired
    JdbcEmpresaRepository jdbcEmpresaRepository;

    @Override
    public void create(Empresa empresa) {
        jdbcEmpresaRepository.create(empresa);
    }

    @Override
    public void update(Empresa empresa) {
        jdbcEmpresaRepository.update(empresa);
    }

    @Override
    public void delete(Long id) {
        jdbcEmpresaRepository.delete(id);
    }

    @Override
    public List<Empresa> findAll() {
        return jdbcEmpresaRepository.findAll();
    }

    @Override
    public Empresa findById(Long aLong) {
        return jdbcEmpresaRepository.findById(aLong);
    }
}
