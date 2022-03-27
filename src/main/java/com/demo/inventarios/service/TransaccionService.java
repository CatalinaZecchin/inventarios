package com.demo.inventarios.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.demo.inventarios.domain.Producto;
import com.demo.inventarios.domain.Transaccion;
import com.demo.inventarios.repository.TransaccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final ProductoService productoService;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository, ProductoService productoService) {
        this.transaccionRepository = transaccionRepository;
        this.productoService = productoService;
    }
    
    public List<Transaccion> getAllTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion findOne(Long id) {
        return transaccionRepository.getById(id);
    }

    public void delete(Long id) {
        boolean exists = transaccionRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("transaction with id " + id + " was not found");
        } else {
            transaccionRepository.deleteById(id);
        }
    }

    @Transactional
    public void update(Long id, Long clientId, String productCode, Long quantity) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                    "transaction with id " + id + " was not found"
                    ));
         //Si hay cliente id y es distinto al que ya está determinado para esta transacción, lo cambiamos           
        if (clientId != null && !Objects.equals(transaccion.getClientId(), clientId)) {
            transaccion.setClientId(clientId);
        }

        //Si hay código de producto y es distinto al ya determinado para la transacción, 
        //buscamos el producto de la transacción original y actualizamos su stock.
        //Solo entonces buscamos el producto nuevo y actualizamos su stock, 
        //y finalmente actualizamos el objeto Transaccion. 
        if (productCode != null && !Objects.equals(transaccion.getProductCode(), productCode)) {
            Producto oldProduct = productoService.getOne(transaccion.getProductCode());

            if ((oldProduct.getStock() - transaccion.getQuantity()) < 0) {
                throw new IllegalArgumentException("No se puede actualizar esta transacción porque el stock quedaría menor a cero");
            }

            oldProduct.setStock(oldProduct.getStock() - transaccion.getQuantity());
            Producto newProduct = productoService.getOne(productCode);
            if ((newProduct.getStock() - quantity) < 0) {
                throw new IllegalArgumentException("No se puede actualizar esta transacción porque el stock quedaría menor a cero");
            }
            newProduct.setStock(newProduct.getStock() - quantity);
            transaccion.setProductCode(productCode);
            transaccion.setQuantity(quantity);
        //Si no hay código de producto para cambiar, entonces solo actualizamos el stock del producto
        //y el objeto Transaccion.
        } else if (productCode == null && quantity != null) {
            Producto newProduct = productoService.getOne(productCode);
            newProduct.setStock(newProduct.getStock() - quantity);
            transaccion.setQuantity(quantity);
        } 
    }

    public Transaccion create(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }


}
