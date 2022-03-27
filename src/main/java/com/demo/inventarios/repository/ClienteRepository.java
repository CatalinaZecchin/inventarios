package com.demo.inventarios.repository;

import java.util.Optional;

import com.demo.inventarios.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query("SELECT c FROM Cliente c WHERE c.photoURL = ?1")
    Optional<Cliente> findByPhotoURL(String photoURL);
}
