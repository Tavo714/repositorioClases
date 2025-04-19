package com.example.service;

import com.example.dto.ProductSupplierDto;
import com.example.entity.ProductSupplier;
import com.example.repository.ProductSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

    @Autowired
    private ProductSupplierRepository repository;

    @Override
    public void save(ProductSupplierDto dto) {
        ProductSupplier relation = new ProductSupplier();
        relation.setId(dto.getId());
        relation.setProductId(dto.getProductId());
        relation.setSupplierId(dto.getSupplierId());
        repository.save(relation);
    }

    @Override
    public List<ProductSupplierDto> getAll() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ProductSupplierDto getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProductSupplierDto mapToDto(ProductSupplier relation) {
        return new ProductSupplierDto(
            relation.getId(),
            relation.getProductId(),
            relation.getSupplierId()
        );
    }
}
