package com.demo.inventarios.web;
import java.util.List;
import com.demo.inventarios.domain.Transaccion;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/transacciones")
public class TransaccionController {
    
    @GetMapping("/getAll")
	public List<Transaccion> getAllPedidos() {
        /* List<Transaccion> result = transaccionService.getAllTransacciones();
        return result; */
		return List.of(new Transaccion(123L, 1L, "productCode", 1L, "time", "tiendaCode")) ;
	}

    @GetMapping("/{id}")
    public Transaccion getOne(@PathVariable Long id) {
        /* Transaccion transaccion = transaccionService.findOne(id);
        return transaccion; */

        return new Transaccion();
    }

    @PostMapping("/create")
    public Transaccion create(@RequestBody Transaccion transaccion) throws Exception {
        if (transaccion.getProductCode() == null) {
            throw new Exception("The product code cannot be null");
        }

        /* Transaccion result = transaccionService.createTransaccion(transaccion);
        return result; */

        return transaccion;
    }

    @PutMapping("/update")
    public Transaccion update(@RequestBody Transaccion transaccion) throws Exception {
        if (transaccion.getId() == null) {
            throw new Exception("The transaction id cannot be null");
        }
        /* Transaccion result = transaccionService.update(transaccion); */
        return transaccion;
    }

    @DeleteMapping("/delete/{id}")
    public Transaccion delete(@PathVariable Long id) {
        /* Transaccion result = transaccionService.deleteAndUpdate(id); */
        return new Transaccion();
    }




}
