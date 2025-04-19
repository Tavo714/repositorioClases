package com.example.service;

import com.example.dto.ProductSupplierDto;

import java.util.List;

public interface ProductSupplierService {
    
    void save(ProductSupplierDto dto);
    
    List<ProductSupplierDto> getAll();
    
    ProductSupplierDto getById(Long id);
    
    void delete(Long id);
}
