package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Empresa;
import pe.isil.proyectodae2.resource.EmpresaResource;

import java.util.List;

@Controller
public class EmpresaController {
    @Autowired
    private EmpresaResource empresaResource;


    @GetMapping("/empresa")
    public String getAllEmpresas(Model model){
        List<Empresa> empresas = (List<Empresa>) empresaResource.getAll().getBody();
        model.addAttribute("empresas", empresas);
        return "empresa";
    }

    @GetMapping("/add-empresa")
    public String addEmpresa(Model model){
        model.addAttribute(new Empresa());
        return "empresa-add";
    }

    @GetMapping("/empresa/{id}")
    public String getEmpresaById(@PathVariable(value = "id") Long id, Model model) {
        Empresa empresa = (Empresa) empresaResource.getById(id).getBody();
        model.addAttribute("empresa", empresa);
        return "empresa-edit";
    }

    @PostMapping("/save-empresa")
    public String createEmpresa(Empresa empresa, Model model){
        empresa.estado = true;
        empresaResource.create(empresa);
        return getAllEmpresas(model);
    }

    @PostMapping("/update-empresa/{id}")
    public String updateEmpresa(@PathVariable(value = "id") Long id, Empresa empresa, Model model){
        empresa.id = id;
        empresa.estado = true;
        empresaResource.update(id, empresa);
        return getAllEmpresas(model);
    }

    @GetMapping("/delete-empresa/{id}")
    public String deleteEmpresa(@PathVariable(value = "id") Long id, Model model){
        ResponseEntity responseEntity = empresaResource.delete(id);
        return getAllEmpresas(model);
    }
}
