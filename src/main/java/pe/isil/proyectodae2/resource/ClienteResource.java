package pe.isil.proyectodae2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Cliente;
import pe.isil.proyectodae2.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity getAllCliente(){

        List<Cliente> clientes = clienteService.findAll();
        if(clientes == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(clientes, HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        Cliente currentCliente = clienteService.findById(id);
        if(currentCliente == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentCliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity create(@RequestBody Cliente cliente){
        clienteService.create(cliente);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Cliente cliente){

        Cliente currentCliente = clienteService.findById(id);
        if(currentCliente == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentCliente.setDni(cliente.getDni());
        currentCliente.setNombres(cliente.getNombres());
        currentCliente.setApellidos(cliente.getApellidos());
        currentCliente.setEmail(cliente.getEmail());
        currentCliente.setTelefono(cliente.getTelefono());
        currentCliente.setPassword(cliente.getPassword());
        currentCliente.setEstado(cliente.getEstado());
        currentCliente.setDireccion(cliente.getDireccion());

        clienteService.update(currentCliente);

        return new ResponseEntity(currentCliente, HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Cliente currentCliente = clienteService.findById(id);
        if(currentCliente == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        clienteService.delete(currentCliente.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

}
