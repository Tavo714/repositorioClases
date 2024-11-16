package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;



import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidosPageableItemResponse {

    private Long pedidoId;
    private Clientes cliente;
    private Date fecha;
    private double total;
    private String estado;

    public static PedidosPageableItemResponse toPedidosPageableItemResponse(Pedidos pedido){
        return new PedidosPageableItemResponse(pedido.getPedidoId(), 
        pedido.getCliente(), 
        pedido.getFecha(), 
        pedido.getTotal(),
        pedido.getEstado());
    }

    

}
