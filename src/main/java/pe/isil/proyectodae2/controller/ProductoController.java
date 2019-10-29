package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.repository.ProductoRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    private Producto producto;

    @GetMapping("/producto")
    public String getAllProductos(Model model){
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @GetMapping("/add-producto")
    public String addProducto(Model model){
        model.addAttribute(new Producto());
        return "producto-add";
    }

    @GetMapping("/producto/{id}")
    public String getProductoById(@PathVariable(value = "id") Long id, Model model) {
        Producto producto = productoRepository.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "producto-edit";
    }

    @PostMapping("/save-producto")
    public String createProducto(Producto producto, Model model){
        producto.estado = true;
        productoRepository.save(producto);
        return getAllProductos(model);
    }

    @PostMapping("/update-producto")
    public String updateProducto(@Valid @RequestBody Producto producto, Model model){
        productoRepository.save(producto);
        return getAllProductos(model);
    }

    @GetMapping("/delete-producto/{id}")
    public String deleteProducto(@PathVariable(value = "id") Long id, Model model){
        productoRepository.deleteById(id);
        return getAllProductos(model);
    }
}
