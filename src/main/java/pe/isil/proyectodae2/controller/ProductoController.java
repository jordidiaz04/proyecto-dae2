package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.repository.producto.ProductoRepository;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

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
        Producto producto = productoRepository.findById(id);
        model.addAttribute("producto", producto);
        return "producto-edit";
    }

    @PostMapping("/save-producto")
    public String createProducto(Producto producto, Model model){
        producto.estado = true;
        productoRepository.create(producto);
        return getAllProductos(model);
    }

    @PostMapping("/update-producto/{id}")
    public String updateProducto(@PathVariable(value = "id") Long id, Producto producto, Model model){
        producto.id = id;
        producto.estado = true;
        productoRepository.update(producto);
        return getAllProductos(model);
    }

    @GetMapping("/delete-producto/{id}")
    public String deleteProducto(@PathVariable(value = "id") Long id, Model model){
        productoRepository.delete(id);
        return getAllProductos(model);
    }
}
