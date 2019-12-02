package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Empresa;
import pe.isil.proyectodae2.model.Marca;
import pe.isil.proyectodae2.resource.EmpresaResource;
import pe.isil.proyectodae2.resource.MarcaResource;

import java.util.List;

@Controller
public class MarcaController {
    @Autowired private MarcaResource marcaResource;
    @Autowired private EmpresaResource empresaResource;

    @GetMapping("/marca")
    public String getAllMarcas(Model model){
        List<Marca> marcas = (List<Marca>) marcaResource.getAll().getBody();
        model.addAttribute("marcas", marcas);
        return "marca";
    }

    @GetMapping("/add-marca")
    public String addMarca(Model model){
        List<Empresa> empresas = (List<Empresa>) empresaResource.getAll().getBody();

        model.addAttribute(new Marca());
        model.addAttribute("empresas", empresas);
        return "marca-add";
    }

    @GetMapping("/marca/{id}")
    public String getMarcaById(@PathVariable(value = "id") Long id, Model model) {
        Marca marca = (Marca) marcaResource.getById(id).getBody();
        List<Empresa> empresas = (List<Empresa>) empresaResource.getAll().getBody();

        model.addAttribute("marca", marca);
        model.addAttribute("empresas", empresas);
        return "marca-edit";
    }

    @PostMapping("/save-marca")
    public String createMarca(Marca marca, Model model){
        marcaResource.create(marca);
        return getAllMarcas(model);
    }

    @PostMapping("/update-marca/{id}")
    public String updateMarca(@PathVariable(value = "id") Long id, Marca marca, Model model){
        marca.id = id;
        marcaResource.update(id, marca);
        return getAllMarcas(model);
    }

    @GetMapping("/delete-marca/{id}")
    public String deleteMarca(@PathVariable(value = "id") Long id, Model model){
        ResponseEntity responseEntity = marcaResource.delete(id);

        return getAllMarcas(model);
    }
}
