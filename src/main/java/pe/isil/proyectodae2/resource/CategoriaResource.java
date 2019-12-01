package pe.isil.proyectodae2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaResource {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity getAll(){
        List<Categoria> categorias = categoriaService.findAll();
        if(categorias == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(categorias, HttpStatus.OK);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        Categoria categoria = categoriaService.findById(id);
        if(categoria == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(categoria, HttpStatus.OK);
    }

    @PostMapping("/categorias")
    public ResponseEntity create(@RequestBody Categoria categoria){
        categoriaService.create(categoria);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Categoria categoria){

        Categoria currentCategoria = categoriaService.findById(id);
        if(currentCategoria == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentCategoria.setNombre(categoria.getNombre());
        currentCategoria.setDescripcion(categoria.getDescripcion());
        currentCategoria.setEstado(categoria.isEstado());

        categoriaService.update(currentCategoria);

        return new ResponseEntity(currentCategoria, HttpStatus.OK);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Categoria categoria = categoriaService.findById(id);
        if(categoria == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        categoriaService.delete(categoria.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
