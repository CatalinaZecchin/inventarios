package com.demo.inventarios.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.demo.inventarios.domain.Cliente;
import com.demo.inventarios.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> getAllClients() {
        return clienteRepository.findAll();
    }

    public Cliente findOne(Long id) {
        return clienteRepository.getById(id);
    }

    public void save(Cliente cliente) {
       Optional<Cliente> clienteOptional = clienteRepository.findByPhotoURL(cliente.getPhotoURL());
       if (clienteOptional.isPresent()) {
           throw new IllegalStateException("photoURL taken");
       } else {
           clienteRepository.save(cliente);
       }
    }

    public void delete(Long id) {
        boolean exists = clienteRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("client with id" + id + "given was not found");
        } else {
            clienteRepository.deleteById(id);
        }
    }

    @Transactional
    public void update(Long id, String name, String photoUrl) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                    "client with id" + id + "given was not found"
                    ));
        if (name != null && name.length() > 0 && !Objects.equals(cliente.getName(), name)) {
            cliente.setName(name);
        }

        if (photoUrl != null && photoUrl.length() > 0 && !Objects.equals(cliente.getPhotoURL(), photoUrl)) {
            cliente.setPhotoURL(photoUrl);
        }
    }


}
