package pe.isil.proyectodae2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Empresa;
import pe.isil.proyectodae2.service.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaResource {
    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresas")
    public ResponseEntity getAll(){
        List<Empresa> empresas = empresaService.findAll();
        if(empresas == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(empresas, HttpStatus.OK);
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        Empresa empresa = empresaService.findById(id);
        if(empresa == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(empresa, HttpStatus.OK);
    }

    @PostMapping("/empresas")
    public ResponseEntity create(@RequestBody Empresa empresa){
        empresaService.create(empresa);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/empresas/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Empresa empresa){

        Empresa currentEmpresa = empresaService.findById(id);
        if(currentEmpresa == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentEmpresa.setNombre(empresa.getNombre());
        currentEmpresa.setEstado(empresa.isEstado());

        empresaService.update(currentEmpresa);

        return new ResponseEntity(currentEmpresa, HttpStatus.OK);
    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Empresa empresa = empresaService.findById(id);
        if(empresa == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        empresaService.delete(empresa.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
