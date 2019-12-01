package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Categoria;
import pe.isil.proyectodae2.repository.categoria.CategoriaRepository;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    private Categoria categoria;

    @GetMapping("/categoria")
    public String getAllCategorias(Model model){
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "categoria";
    }

    @GetMapping("/add-categoria")
    public String addCategoria(Model model){
        model.addAttribute(new Categoria());
        return "categoria-add";
    }

    @GetMapping("/categoria/{id}")
    public String getCategoriaById(@PathVariable(value = "id") Long id, Model model) {
        Categoria categoria = categoriaRepository.findById(id);
        model.addAttribute("categoria", categoria);
        return "categoria-edit";
    }

    @PostMapping("/save-categoria")
    public String createCategoria(Categoria categoria, Model model){
        categoria.estado = true;
        categoriaRepository.create(categoria);
        return getAllCategorias(model);
    }

    @PostMapping("/update-categoria/{id}")
    public String updateCategoria(@PathVariable(value = "id") Long id, Categoria categoria, Model model){
        categoria.id = id;
        categoria.estado = true;
        categoriaRepository.update(categoria);
        return getAllCategorias(model);
    }

    @GetMapping("/delete-categoria/{id}")
    public String deleteCategoria(@PathVariable(value = "id") Long id, Model model){
        categoriaRepository.delete(id);
        return getAllCategorias(model);
    }
}
