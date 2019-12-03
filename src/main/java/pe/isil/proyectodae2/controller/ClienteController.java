package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Cliente;
import pe.isil.proyectodae2.service.ClienteService;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente")
    public String getCliente(Model model){
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente";
    }

    @PostMapping("clientes/save")
    public String saveCliente(Cliente cliente, Model model){
        clienteService.create(cliente);

        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente";
    }

    @GetMapping("/clientes/add")
    public String addStudent(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-add";
    }

    @GetMapping("/clientes/edit/{id}")
    public String getClienteUpdate(@PathVariable Long id,
                                      Model model) {

        Cliente currentCliente = clienteService.findById(id);
        model.addAttribute("cliente", currentCliente);
        return "cliente-edit";
    }

    @PostMapping("/clientes/update/{id}")
    public String updateCliente(@PathVariable Long id,
                                Cliente cliente,
                                Model model) {

        //Update
        clienteService.update(cliente);

        //list
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente";
    }

    @GetMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable Long id,
                                Model model) {

        Cliente currentetCliente = clienteService.findById(id);

        //Delete
        clienteService.delete(id);

        //list
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente";
    }
}
