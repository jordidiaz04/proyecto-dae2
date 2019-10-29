package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.jdbc.UsuarioJdbc;
import pe.isil.proyectodae2.model.Usuario;
import pe.isil.proyectodae2.repository.UsuarioRepository;

@Controller
public class LoginController {
    @Autowired
    private UsuarioJdbc usuarioJdbc;
    private Usuario usuario;

    @GetMapping(value = {"/", "/login"})
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login-usuario")
    public String loginUsuario(Usuario usuario){
        Usuario obj = usuarioJdbc.login(usuario);
        if(obj != null) return "index";
        else return "login?error=true";
    }
}
