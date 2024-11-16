package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleGetByIDResponse {
    private Long detalleId;
    private Pedidos pedido;
    private Productos producto;
    private int cantidad;
    private double precioUnitario;
    private String estado;

    
    public static DetalleGetByIDResponse toDetalleGetByIDResponse(DetallePedidos detallePedidos){
        return new DetalleGetByIDResponse(detallePedidos.getDetalleId(),
         detallePedidos.getPedido(),
          detallePedidos.getProducto(), 
          detallePedidos.getCantidad(),
          detallePedidos.getPrecioUnitario(),
          detallePedidos.getEstado()
        );
    }


}
