package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleGetByIdViewResponse {
    private Long detalleId;
    private Long pedioId;
    private String pedidoNombreCliente;
    private String productoNombre;
    private int cantidad;
    private double precioUnitario;
    private String estado;

    public static DetalleGetByIdViewResponse fromDetallePedidos(DetallePedidos detallePedidos) {
        return new DetalleGetByIdViewResponse(
            detallePedidos.getDetalleId(),
            detallePedidos.getPedido().getPedidoId(),
            detallePedidos.getPedido().getCliente().getNombreCliente(), 
            detallePedidos.getProducto().getNombreProducto(), 
            detallePedidos.getCantidad(),
            detallePedidos.getPrecioUnitario(),
            detallePedidos.getEstado()
        );
    }
}
