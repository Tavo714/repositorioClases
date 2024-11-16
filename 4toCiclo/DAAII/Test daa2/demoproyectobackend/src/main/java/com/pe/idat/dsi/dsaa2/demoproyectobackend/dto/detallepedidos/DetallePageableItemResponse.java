package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DetallePageableItemResponse {

    private Long detalleId;
    private Pedidos pedido;
    private Productos producto;
    private int cantidad;
    private double precioUnitario;
    private String estado;

    public static DetallePageableItemResponse toDetallePageableItemResponse(DetallePedidos detalle){
        return new DetallePageableItemResponse(detalle.getDetalleId(), 
                                                detalle.getPedido(), 
                                                detalle.getProducto(), 
                                                detalle.getCantidad(),
                                                detalle.getPrecioUnitario(), 
                                                detalle.getEstado());
    }

    

}
