package com.example.repository;

import com.example.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    // Para login (por ejemplo)
    Optional<Cliente> findByDniclienteAndClave(String dnicliente, String clave);

    Optional<Cliente> findByDnicliente(String dnicliente);
}
