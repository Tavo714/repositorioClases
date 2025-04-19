package com.example.controller;

import com.example.dto.CompraDto;
import com.example.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping("/agregar")
    public ResponseEntity<Void> agregar(@RequestBody CompraDto dto) {
        compraService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id, @RequestBody CompraDto dto) {
        compraService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CompraDto>> listar() {
        return ResponseEntity.ok(compraService.getAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CompraDto> buscarPorId(@PathVariable Long id) {
        CompraDto dto = compraService.getById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        compraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
