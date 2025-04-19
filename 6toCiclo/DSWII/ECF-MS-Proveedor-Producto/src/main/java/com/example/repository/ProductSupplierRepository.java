package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ProductSupplier;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Long> {
    // Puedes agregar métodos personalizados aquí si lo necesitas luego
}
