package pe.isil.proyectodae2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectodae2.model.Cliente;
import pe.isil.proyectodae2.repository.JdbcClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    JdbcClienteRepository jdbcClienteRepository;

    public void create(Cliente cliente){jdbcClienteRepository.create(cliente);}

    public void update(Cliente cliente){
        jdbcClienteRepository.update(cliente);
    }

    public void delete(Long id){
        jdbcClienteRepository.delete(id);
    }

    public void save(Cliente cliente){jdbcClienteRepository.add(cliente);}

    public Cliente findById(Long id){
        return jdbcClienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return jdbcClienteRepository.findAll();
    }



}
