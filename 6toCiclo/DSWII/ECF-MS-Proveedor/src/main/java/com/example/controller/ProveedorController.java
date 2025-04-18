package com.example.controller;

import com.example.dto.ProveedorDto;
import com.example.entity.Proveedor;
import com.example.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Proveedor proveedor) {
        proveedorService.insert(proveedor);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProveedorDto> getProveedor(@PathVariable("id") Long id) {
        ProveedorDto proveedorDto = proveedorService.getById(id);
        return ResponseEntity.ok(proveedorDto);
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<ProveedorDto>> listar() {
        return ResponseEntity.ok(proveedorService.getAll());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        proveedor.setId(id); // Asegura que se use el ID del path
        proveedorService.update(proveedor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        proveedorService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
