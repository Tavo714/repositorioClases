package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductosUpdateResponse {
    private Long productoId;
    private String nombreProducto;
    private String descripcion;
    private double precio;
    private int stock;
    private String estado;  

    public static ProductosUpdateResponse toProductosUpdateResponse(Productos productos) {
        return new ProductosUpdateResponse(
            productos.getProductoId(), 
            productos.getNombreProducto(), 
            productos.getDescripcion(), 
            productos.getPrecio(), 
            productos.getStock(), 
            productos.getEstado()
        );                                  
    }
}
