package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ProductosInsertResponse {

    private Long productoId;
    private String nombreProducto;
    private String descripcion;
    private double precio;
    private int stock;
    private String estado; 

    public static ProductosInsertResponse toProductosInsertResponse(Productos productos){
        return new ProductosInsertResponse( productos.getProductoId(), 
                                            productos.getNombreProducto(), 
                                            productos.getDescripcion(), 
                                            productos.getPrecio(), 
                                            productos.getStock(), 
                                            productos.getEstado());                                   
    }
    
}
