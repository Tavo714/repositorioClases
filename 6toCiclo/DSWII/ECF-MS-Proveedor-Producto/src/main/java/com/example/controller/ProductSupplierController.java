package com.example.controller;

import com.example.dto.ProductSupplierDto;
import com.example.service.ProductSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos-proveedores")
public class ProductSupplierController {

    @Autowired
    private ProductSupplierService service;

    @PostMapping("/agregar")
    public ResponseEntity<Void> agregar(@RequestBody ProductSupplierDto dto) {
        service.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProductSupplierDto>> listar() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id, @RequestBody ProductSupplierDto dto) {
        dto.setId(id); // Asegura que el ID sea el del path
        service.save(dto); // Reutilizas el método save, que hace insert o update según el ID
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
