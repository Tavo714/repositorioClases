package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleUpdateResponse {
    private Long detalleId;
    private Long pedidoId;
    private Long producto;
    private int cantidad;
    private double precioUnitario;
    private String estado;

    public static DetalleUpdateResponse toDetalleUpdateResponse(DetallePedidos detalle){
        return new DetalleUpdateResponse(detalle.getDetalleId(), 
        detalle.getPedido().getPedidoId(), 
        detalle.getProducto().getProductoId(), 
        detalle.getCantidad(), 
        detalle.getPrecioUnitario(), 
        detalle.getEstado());
    }

}
