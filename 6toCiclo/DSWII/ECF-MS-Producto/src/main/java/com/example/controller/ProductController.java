package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Product product) {
        System.out.println("PRODUCTO RECIBIDO: " + product);
        productService.insert(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getById(id);
        return ResponseEntity.ok(productDto);
    }
    	
    @GetMapping("/listar")
    public ResponseEntity<Iterable<ProductDto>> listar() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Product product) {
        ProductDto existing = productService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        product.setId(id); // Asegurarse que el ID del path se use
        productService.update(product);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

