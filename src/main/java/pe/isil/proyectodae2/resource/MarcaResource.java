package pe.isil.proyectodae2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.service.MarcaService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarcaResource {
    @Autowired
    MarcaService marcaService;

    @GetMapping("/marcas")
    public ResponseEntity getAll(){
        List<Marca> marcas = marcaService.findAll();
        if(marcas == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(marcas, HttpStatus.OK);
    }

    @GetMapping("/marcas/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        Marca marca = marcaService.findById(id);
        if(marca == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(marca, HttpStatus.OK);
    }

    @PostMapping("/marcas")
    public ResponseEntity create(@RequestBody Marca marca){
        marcaService.create(marca);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/marcas/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Marca marca){

        Marca currentMarca = marcaService.findById(id);
        if(currentMarca == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentMarca.setNombre(marca.getNombre());
        currentMarca.setEstado(marca.isEstado());
        currentMarca.setDescripcion(marca.getDescripcion());
        currentMarca.setIdEmpresa(marca.getIdEmpresa());

        marcaService.update(currentMarca);

        return new ResponseEntity(currentMarca, HttpStatus.OK);
    }

    @DeleteMapping("/marcas/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Marca marca = marcaService.findById(id);
        if(marca == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        marcaService.delete(marca.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
