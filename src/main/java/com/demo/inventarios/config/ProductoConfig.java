package com.demo.inventarios.config;

import java.util.List;

import com.demo.inventarios.domain.Cliente;
import com.demo.inventarios.domain.Producto;
import com.demo.inventarios.repository.ClienteRepository;
import com.demo.inventarios.repository.ProductoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductoConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductoRepository repository) {
        return args -> {
            String url = "https://mocki.io/v1/38e47bef-0c6a-4d3d-85ea-4231fe6d939d";
            RestTemplate restTemplate = new RestTemplate();
            List<Producto> productos = restTemplate.getForObject(url, List<Producto.class>);
            repository.saveAll(productos);
        };
    }

}
