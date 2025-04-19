package com.example.service;

import com.example.dto.ProveedorDto;
import com.example.entity.Proveedor;
import com.example.repository.ProveedorRepository;
import com.example.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public void insert(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public void update(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public ProveedorDto getById(Long id) {
        return proveedorRepository.findById(id)
                .map(p -> new ProveedorDto(
                    p.getId(),
                    p.getRazonSocial(),
                    p.getDireccion(),
                    p.getTelefono(),
                    p.getCorreo(),
                    p.getContacto()))
                .orElse(null);
    }

    @Override
    public List<ProveedorDto> getAll() {
        List<Proveedor> proveedores = (List<Proveedor>) proveedorRepository.findAll();
        return proveedores.stream()
                .map(p -> new ProveedorDto(
                    p.getId(),
                    p.getRazonSocial(),
                    p.getDireccion(),
                    p.getTelefono(),
                    p.getCorreo(),
                    p.getContacto()))
                .collect(Collectors.toList());
    }
}
