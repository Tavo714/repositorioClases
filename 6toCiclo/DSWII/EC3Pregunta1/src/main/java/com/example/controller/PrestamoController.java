package com.example.controller;

import com.example.entity.Prestamo;
import com.example.service.PrestamoService;
import com.example.service.ClienteService;
import com.example.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listarPrestamos() {
        return ResponseEntity.ok(prestamoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPrestamo(@PathVariable Long id) {
        return prestamoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{dni}")
    public ResponseEntity<List<Prestamo>> listarPorCliente(@PathVariable String dni) {
        return ResponseEntity.ok(prestamoService.listarPorCliente(dni));
    }

    @PostMapping
    public ResponseEntity<Prestamo> registrarPrestamo(@RequestBody Prestamo prestamo) {
        // Validar que el cliente exista
        Cliente cliente = clienteService.buscarPorDni(prestamo.getCliente().getDnicliente())
                .orElse(null);

        if (cliente == null) {
            return ResponseEntity.badRequest().build();
        }

        prestamo.setCliente(cliente); // Asociamos el cliente real
        return ResponseEntity.ok(prestamoService.registrar(prestamo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        if (!prestamoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        prestamo.setNroprestamo(id);
        return ResponseEntity.ok(prestamoService.actualizar(prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
        if (!prestamoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        prestamoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
