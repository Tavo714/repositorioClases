package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;

import java.util.Date;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidosUpdateRequest {

    private Long pedidoId;
    private Long cliente;
    private Date fecha;
    private double total;
    private String estado;

    public Pedidos toPedidos(Clientes cliente)
    {
        return new Pedidos(
        this.pedidoId,
        cliente,
        this.fecha,
        this.total,
        this.estado);
    }

}
