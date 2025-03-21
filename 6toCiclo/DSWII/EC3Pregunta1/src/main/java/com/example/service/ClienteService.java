package com.example.service;

import com.example.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorDni(String dni);
    Cliente registrar(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    void eliminar(String dni);
}
