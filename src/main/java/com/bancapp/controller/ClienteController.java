package com.bancapp.controller;

import com.bancapp.entity.Cliente;
import com.bancapp.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarTodo();
        model.addAttribute("clientes", clientes);
        return "views/clientes";
    }
}
