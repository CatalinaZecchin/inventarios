package com.demo.inventarios.config;

import java.util.List;

import com.demo.inventarios.domain.Cliente;
import com.demo.inventarios.repository.ClienteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClienteRepository repository) {
        return args -> {
            Cliente cliente1 = new Cliente(
                    "Cliente 1",
                    "photoURL.com/e2342");
            Cliente cliente2 = new Cliente(
                    "Cliente 2",
                    "photoURL.com/e3242342");
            repository.saveAll(List.of(cliente1, cliente2));
        };
    }

}
