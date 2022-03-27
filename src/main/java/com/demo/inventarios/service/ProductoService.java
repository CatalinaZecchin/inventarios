package com.demo.inventarios.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.demo.inventarios.domain.Producto;
import com.demo.inventarios.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getOne(String code) {
        return productoRepository.getById(code);
    }

    @Transactional
    public void updateStock(String code, Long stock) {
        Producto producto = productoRepository.findById(code)
                .orElseThrow(() -> new IllegalStateException(
                    "product with code" + code + "given was not found"
                    ));

        if (Objects.equals(producto.getStock(), 0L)) {
            throw new IllegalStateException("Stock is 0");
        } else {
            producto.setStock(stock);
        }
    }


}
