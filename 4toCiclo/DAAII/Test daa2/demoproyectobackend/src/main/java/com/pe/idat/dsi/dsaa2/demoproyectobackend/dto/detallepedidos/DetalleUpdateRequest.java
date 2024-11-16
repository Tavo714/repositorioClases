package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleUpdateRequest {
    private Long detalleId;
    private Long pedidoId;
    private Long productoId;
    private int cantidad;
    private double precioUnitario;
    private String estado;

    public DetallePedidos toDetallePedidos(Pedidos pedido, Productos producto)
    {
        return new DetallePedidos(
        this.detalleId,
        pedido,
        producto,
        this.cantidad,
        this.precioUnitario,
        this.estado);
    }

}
