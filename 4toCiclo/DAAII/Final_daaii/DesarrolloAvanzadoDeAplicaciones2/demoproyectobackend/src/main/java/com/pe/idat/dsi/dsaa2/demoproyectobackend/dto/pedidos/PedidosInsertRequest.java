package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;

import java.util.Date;
import java.util.List;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidosInsertRequest {
    private Long pedidoId;
    private Long clienteId;
    private Date fecha;
    private double total;
    private String estado;
    private List<DetalleInsertRequest> detalles;

    public Pedidos toPedidos(Clientes cliente){
        return new Pedidos(
        this.pedidoId,
        cliente,
        this.fecha,
        this.total,
        this.estado);
    }

    

}
