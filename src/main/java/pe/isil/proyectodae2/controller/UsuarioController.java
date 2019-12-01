package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.proyectodae2.model.Usuario;
import pe.isil.proyectodae2.repository.usuario.UsuarioRepository;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    @GetMapping("/usuario")
    public String getAllUsuarios(Model model){
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

    @GetMapping("/add-usuario")
    public String addUsuario(Model model){
        model.addAttribute(new Usuario());
        return "usuario-add";
    }

    @GetMapping("/usuario/{id}")
    public String getUsuarioById(@PathVariable(value = "id") Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id);
        model.addAttribute("usuario", usuario);
        return "usuario-edit";
    }

    @PostMapping("/save-usuario")
    public String createUsuario(Usuario usuario, Model model){
        usuario.estado = true;
        usuarioRepository.create(usuario);
        return getAllUsuarios(model);
    }

    @PostMapping("/update-usuario/{id}")
    public String updateUsuario(@PathVariable Long id,Usuario usuario, Model model){
        usuario.id = id;
        usuario.estado = true;
        usuarioRepository.update(usuario);
        return getAllUsuarios(model);
    }

    @GetMapping("/delete-usuario/{id}")
    public String deleteUsuario(@PathVariable(value = "id") Long id, Model model){
        usuarioRepository.delete(id);
        return getAllUsuarios(model);
    }
}
