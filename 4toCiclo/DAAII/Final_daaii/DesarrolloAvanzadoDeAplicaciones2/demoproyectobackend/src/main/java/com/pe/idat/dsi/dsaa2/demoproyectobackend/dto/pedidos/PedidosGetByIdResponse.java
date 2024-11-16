package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;

import java.util.Date;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidosGetByIdResponse {
    private Long pedidoId;
    private Clientes cliente;
    private Date fecha;
    private double total;
    private String estado;

    
    public static PedidosGetByIdResponse toPedidosGetByIdResponse(Pedidos pedidos){
        return new PedidosGetByIdResponse(pedidos.getPedidoId(),
        pedidos.getCliente(),
        pedidos.getFecha(), 
        pedidos.getTotal(),
        pedidos.getEstado()
        );
    }


}
