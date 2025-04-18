package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
