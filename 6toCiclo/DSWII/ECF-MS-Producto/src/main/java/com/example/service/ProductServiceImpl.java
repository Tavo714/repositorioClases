package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductRepository productRepository;

    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return mapToDto(product);
    }

    private ProductDto mapToDto(Product product) {
        if (product == null) return null;
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory(),
                product.getUnitPrice(),
                product.getEstado()
        );
    }
    
    @Override
    public Iterable<ProductDto> getAll() {
        Iterable<Product> productos = productRepository.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product p : productos) {
            dtoList.add(mapToDto(p));
        }
        return dtoList;
    }

    @Override
    public void update(Product product) {
        if (productRepository.existsById(product.getId())) {
            productRepository.save(product);
        }
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
