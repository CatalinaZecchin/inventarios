package com.demo.inventarios.web;
import java.util.List;
import com.demo.inventarios.domain.Transaccion;
import com.demo.inventarios.service.TransaccionService;

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
@RequestMapping(path="api/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }
    
    @GetMapping("/getAll")
	public List<Transaccion> getAllPedidos() {
        return transaccionService.getAllTransacciones();
	}

    @GetMapping("/{id}")
    public Transaccion getOne(@PathVariable Long id) {
        return transaccionService.findOne(id);
    }

    @PostMapping("/create")
    public Transaccion create(@RequestBody Transaccion transaccion) throws Exception {
        if (transaccion.getProductCode() == null) {
            throw new Exception("The product code cannot be null");
        }

        return transaccionService.create(transaccion);
    }

    @PutMapping("/update/{id}")
    public void update(
        @PathVariable("id") Long id,
        @RequestParam(required = false) Long clientId,
        @RequestParam(required = false) String productCode,
        @RequestParam(required = false) Long quantity
        ) throws Exception {
        if (id == null) {
            throw new Exception("The transaction id cannot be null");
        }
         transaccionService.update(id, clientId, productCode, quantity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        transaccionService.delete(id);
    }

}
