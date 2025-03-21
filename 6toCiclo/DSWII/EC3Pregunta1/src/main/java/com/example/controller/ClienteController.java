package com.example.controller;

import com.example.entity.Cliente;
import com.example.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // Para evitar problemas con CORS si luego consumes desde frontend
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable String dni) {
        return clienteService.buscarPorDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.registrar(cliente));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable String dni, @RequestBody Cliente cliente) {
        if (!clienteService.buscarPorDni(dni).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setDnicliente(dni); // aseguramos que el DNI se mantenga
        return ResponseEntity.ok(clienteService.actualizar(cliente));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String dni) {
        if (!clienteService.buscarPorDni(dni).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.eliminar(dni);
        return ResponseEntity.noContent().build();
    }
}
