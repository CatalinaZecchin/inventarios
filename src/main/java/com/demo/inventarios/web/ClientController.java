package com.demo.inventarios.web;
import java.util.List;

import com.demo.inventarios.domain.Cliente;
import com.demo.inventarios.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/clientes")
public class ClientController {

    private final ClienteService clienteService;

    @Autowired
    public ClientController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @GetMapping("/getAll")
	public List<Cliente> getAllClients() {
        return clienteService.getAllClients();
	}

    @GetMapping("/{id}")
    public Cliente getOne(@PathVariable Long id) {
        return clienteService.findOne(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Cliente cliente) throws Exception {
        if (cliente.getName() == null) {
            throw new Exception("The client name cannot be null");
        }
        clienteService.save(cliente);
    }

    @PutMapping("/update/{id}")
    public void update(
        @PathVariable("id") Long id, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String photoUrl) throws Exception {
        clienteService.update(id, name, photoUrl);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }




}
