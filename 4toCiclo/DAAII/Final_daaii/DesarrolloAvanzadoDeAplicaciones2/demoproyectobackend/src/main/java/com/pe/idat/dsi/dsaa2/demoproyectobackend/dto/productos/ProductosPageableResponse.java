package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductosPageableResponse {
    private int totalItems;
    private int totalPages;
    
    private List<ProductosPageableItemResponse> items;

    public static ProductosPageableResponse toProductosPageableResponse(Page<Productos> productos){
        return new ProductosPageableResponse((int)productos.getTotalElements(), 
                                                  productos.getTotalPages(), 
                                                  productos.getContent().stream().map(ProductosPageableItemResponse::toProductosPageableItemResponse).toList());
                                        }
}
