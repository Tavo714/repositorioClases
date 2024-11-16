package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosGetByIdResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosInsertResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosPageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosUpdateRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosUpdateResponse;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ProductosService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductosRestController {
    private ProductosService productosService;

    public ProductosRestController(ProductosService productosService){
        this.productosService = productosService;
    }

    @GetMapping()
    public List<Productos> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        ProductosSorting sorting = new ProductosSorting(columnOrder, direction);
        return productosService.getAll(sorting);
    }
    @GetMapping("/page")
    public ResponseEntity<ProductosPageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        ProductosPageable pageable = new ProductosPageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<Productos> response = productosService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ProductosPageableResponse.toProductosPageableResponse(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosGetByIdResponse> getById(@PathVariable Long id) {
        Productos productos = productosService.getById(id);
        if (productos == null || productos.getProductoId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProductosGetByIdResponse.toProductosGetByIdResponse(productos));
    }
    
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductosInsertResponse> insertProductos(@RequestBody ProductosInsertRequest entity) {
        Productos productos = productosService.insertProductos(ProductosInsertRequest.toProductos(entity));
        if (productos == null || productos.getProductoId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ProductosInsertResponse.toProductosInsertResponse(productos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosUpdateResponse> updateProductos(@PathVariable Long id, @RequestBody ProductosUpdateRequest entity) {
        entity.setProductoId(id);
        Productos productos = productosService.updateProductos(ProductosUpdateRequest.toProductos(entity));
        if(productos == null){
            return ResponseEntity.badRequest().build();
        }
        if(productos.getProductoId() == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ProductosUpdateResponse.toProductosUpdateResponse(productos));
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteProductos(@PathVariable Long id)    
    {
        boolean hasDeleted = productosService.deleteProductos(id);
        if(!hasDeleted){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok( "El producto ha sido eliminado correctamente");
    }
}
