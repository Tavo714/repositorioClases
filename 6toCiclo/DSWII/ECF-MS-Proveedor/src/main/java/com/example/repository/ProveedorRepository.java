package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.entity.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
}
