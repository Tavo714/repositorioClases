package com.example.service;

import com.example.dto.ProductDto;
import com.example.entity.Product;

public interface ProductService {
	
	 void insert(Product product);
	    ProductDto getById(Long id);	    
	 Iterable<ProductDto> getAll();
	 void update(Product product);
	 void delete(Long id);


}
