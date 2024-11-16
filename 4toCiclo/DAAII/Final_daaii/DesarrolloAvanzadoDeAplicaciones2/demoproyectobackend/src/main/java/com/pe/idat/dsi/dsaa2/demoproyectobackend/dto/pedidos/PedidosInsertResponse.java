package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;

import java.util.Date;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidosInsertResponse {

    private Long pedidoId;
    private Long cliente;
    private Date fecha;
    private double total;
    private String estado;

    public static PedidosInsertResponse toPedidosInsertResponse(Pedidos pedido){
        return new PedidosInsertResponse(   
            pedido.getPedidoId(),
            pedido.getCliente().getClienteId(),
            pedido.getFecha(), 
            pedido.getTotal(), 
            pedido.getEstado());
    }


}
