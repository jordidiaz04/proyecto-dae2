package pe.isil.proyectodae2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.proyectodae2.model.Cliente;
import pe.isil.proyectodae2.repository.cliente.ClienteRepository;


import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente;

    @GetMapping("/cliente")
    public String getAllClientes(Model model){
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente";
    }

    @GetMapping("/add-cliente")
    public String addCliente(Model model){
        model.addAttribute(new Cliente());
        return "cliente-add";
    }

    @GetMapping("/cliente/{id}")
    public String getClienteById(@PathVariable(value = "id") Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente-edit";
    }

    @PostMapping("/save-cliente")
    public String createCliente(Cliente cliente, Model model){
        cliente.estado = true;
        clienteRepository.create(cliente);
        return getAllClientes(model);
    }

    @PostMapping("/update-cliente/{id}")
    public String updateCliente(@PathVariable(value = "id") Long id, Cliente cliente, Model model){
        cliente.id = id;
        cliente.estado = true;
        clienteRepository.update(cliente);
        return getAllClientes(model);
    }

    @GetMapping("/delete-cliente/{id}")
    public String deleteCliente(@PathVariable(value = "id") Long id, Model model){
        clienteRepository.delete(id);
        return getAllClientes(model);
    }
}
