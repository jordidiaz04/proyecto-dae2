package pe.isil.proyectodae2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.model.ProductoCompleto;
import pe.isil.proyectodae2.service.ProductoCompletoService;
import pe.isil.proyectodae2.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoCompletoResource {
    @Autowired
    ProductoCompletoService productoService;

    @GetMapping("/productoCompleto")
    public ResponseEntity getAll(){
        List<ProductoCompleto> productos = productoService.findAll();
        if(productos == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(productos, HttpStatus.OK);
    }

    @GetMapping("/productoCompleto/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        ProductoCompleto producto = productoService.findById(id);
        if(producto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(producto, HttpStatus.OK);
    }
}
