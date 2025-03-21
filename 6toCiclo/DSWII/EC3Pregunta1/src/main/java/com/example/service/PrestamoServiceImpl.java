package com.example.service;

import com.example.entity.Prestamo;
import com.example.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> listarTodos() {
        return prestamoRepository.findAll();
    }

    @Override
    public List<Prestamo> listarPorCliente(String dniCliente) {
        return prestamoRepository.findByClienteDnicliente(dniCliente);
    }

    @Override
    public Optional<Prestamo> buscarPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public Prestamo registrar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void eliminar(Long id) {
        prestamoRepository.deleteById(id);
    }
}
