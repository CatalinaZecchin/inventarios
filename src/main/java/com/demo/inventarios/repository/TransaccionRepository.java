package com.demo.inventarios.repository;

import com.demo.inventarios.domain.Transaccion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>  {
    
}
