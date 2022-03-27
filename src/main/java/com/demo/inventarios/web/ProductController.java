package com.demo.inventarios.web;

import java.net.URISyntaxException;
import java.util.List;

import com.demo.inventarios.domain.Cliente;
import com.demo.inventarios.domain.Producto;
import com.demo.inventarios.service.ProductoService;

import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/productos")
public class ProductController {

    private final ProductoService productoService;

    @Autowired
    public ProductController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @GetMapping("/get-all")
	public List<Producto> getAllProducts() {
        return productoService.getAllProductos();
	}

    @PutMapping("/update-stock/{id}")
    public void updateStock(
        @PathVariable("id") String code,
        @RequestParam(required = true) Long newStock) throws Exception {
        if (code == null) {
            throw new Exception("The product code cannot be null for updating stock");
        } else if (newStock == null) {
            throw new Exception("The stock cannot be null for updating stock");
        } else {
            productoService.updateStock(code, newStock);
        }
    }


}
