package com.example.service;

import com.example.dto.ProveedorDto;
import com.example.entity.Proveedor;
import java.util.List;

public interface ProveedorService {
    void insert(Proveedor proveedor);
    void update(Proveedor proveedor);
    void delete(Long id);
    ProveedorDto getById(Long id);
    List<ProveedorDto> getAll();
}
