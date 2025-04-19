package com.example.service;

import com.example.dto.CompraDto;
import java.util.List;

public interface CompraService {
    void save(CompraDto compraDto);
    List<CompraDto> getAll();
    CompraDto getById(Long id);
    void update(Long id, CompraDto compraDto);
    void delete(Long id);
}
