package com.demo.inventarios.web;

import java.net.URISyntaxException;
import java.util.List;

import com.demo.inventarios.domain.Cliente;
import com.demo.inventarios.domain.Producto;

import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/productos")
public class ProductController {
    
    @GetMapping("/get-all")
	public List<Producto> getAllProducts() {
        /* List<Producto> result = productoService.getAllProducts();
        return result; */
		return List.of(new Producto(
            "31231", "Product1", 5L
            )) ;
	}

    @PutMapping("/update-stock")
    public Producto updateStock(@RequestBody Producto producto) throws Exception {
        if (producto.getCode() == null) {
            throw new Exception("The product code cannot be null for updating stock");
        }
        /* Producto result = productoService.updateStock(producto); */
        return producto;
    }


}
