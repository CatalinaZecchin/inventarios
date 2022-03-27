package com.demo.inventarios.config;

import java.util.List;

import com.demo.inventarios.domain.Tienda;
import com.demo.inventarios.repository.TiendaRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TiendaConfig {

    @Bean
    CommandLineRunner commandLineRunner(TiendaRepository repository) {
        return args -> {
            Tienda tienda1 = new Tienda(
                    "Tienda A");
            Tienda tienda2 = new Tienda(
                    "Tienda B");
            Tienda tienda3 = new Tienda(
                    "Tienda C");
            Tienda tienda4 = new Tienda(
                    "Tienda D");
            repository.saveAll(List.of(tienda1, tienda2, tienda3, tienda4));
        };
    }

}
