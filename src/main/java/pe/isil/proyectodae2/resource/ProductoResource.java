package pe.isil.proyectodae2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoResource {
    @Autowired
    ProductoService productoService;


    //GET
    @GetMapping("/productos")
    public ResponseEntity getAll(){
        List<Producto> productos = productoService.findAll();
        if(productos == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(productos, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/productos/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        Producto producto = productoService.findById(id);
        if(producto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @PostMapping("/productos")
    public ResponseEntity create(@RequestBody Producto producto){
        productoService.create(producto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Producto producto){

        Producto currentProducto = productoService.findById(id);
        if(currentProducto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentProducto.setNombre(producto.getNombre());
        currentProducto.setCodigo(producto.getCodigo());
        currentProducto.setEstado(producto.isEstado());
        currentProducto.setIdCategoria(producto.getIdCategoria());
        currentProducto.setIdMarca(producto.getIdMarca());
        currentProducto.setPrecio(producto.getPrecio());
        currentProducto.setStock(producto.getStock());

        productoService.update(currentProducto);

        return new ResponseEntity(currentProducto, HttpStatus.OK);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Producto producto = productoService.findById(id);
        if(producto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        productoService.delete(producto.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
