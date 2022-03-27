package com.demo.inventarios.repository;

import com.demo.inventarios.domain.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, String> {
}
