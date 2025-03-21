package com.example.service;

import com.example.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    List<Prestamo> listarTodos();
    List<Prestamo> listarPorCliente(String dniCliente);
    Optional<Prestamo> buscarPorId(Long id);
    Prestamo registrar(Prestamo prestamo);
    Prestamo actualizar(Prestamo prestamo);
    void eliminar(Long id);
}
