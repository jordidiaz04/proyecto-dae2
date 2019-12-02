package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.model.Producto;
import pe.isil.proyectodae2.model.ProductoCompleto;
import pe.isil.proyectodae2.repository.producto.ProductoRepository;
import pe.isil.proyectodae2.resource.CategoriaResource;
import pe.isil.proyectodae2.resource.MarcaResource;
import pe.isil.proyectodae2.resource.ProductoCompletoResource;
import pe.isil.proyectodae2.resource.ProductoResource;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired private ProductoCompletoResource productoCompletoResource;
    @Autowired private ProductoResource productoResource;
    @Autowired private CategoriaResource categoriaResource;
    @Autowired private MarcaResource marcaResource;

    @GetMapping("/producto")
    public String getAllProductos(Model model){
        List<ProductoCompleto> productos = (List<ProductoCompleto>) productoCompletoResource.getAll().getBody();

        model.addAttribute("productos", productos);
        return "producto";
    }

    @GetMapping("/add-producto")
    public String addProducto(Model model){
        List<Categoria> categorias = (List<Categoria>) categoriaResource.getAll().getBody();
        List<Marca> marcas = (List<Marca>) marcaResource.getAll().getBody();
        model.addAttribute(new Producto());
        model.addAttribute("categorias", categorias);
        model.addAttribute("marcas", marcas);
        return "producto-add";
    }

    @GetMapping("/producto/{id}")
    public String getProductoById(@PathVariable(value = "id") Long id, Model model) {
        Producto producto = (Producto) productoResource.getById(id).getBody();
        List<Categoria> categorias = (List<Categoria>) categoriaResource.getAll().getBody();
        List<Marca> marcas = (List<Marca>) marcaResource.getAll().getBody();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        model.addAttribute("marcas", marcas);
        return "producto-edit";
    }

    @PostMapping("/save-producto")
    public String createProducto(Producto producto, Model model){
        productoResource.create(producto);
        return getAllProductos(model);
    }

    @PostMapping("/update-producto/{id}")
    public String updateProducto(@PathVariable(value = "id") Long id, Producto producto, Model model){
        producto.id = id;
        productoResource.update(id, producto);
        return getAllProductos(model);
    }

    @GetMapping("/delete-producto/{id}")
    public String deleteProducto(@PathVariable(value = "id") Long id, Model model){
        productoResource.delete(id);
        return getAllProductos(model);
    }
}
