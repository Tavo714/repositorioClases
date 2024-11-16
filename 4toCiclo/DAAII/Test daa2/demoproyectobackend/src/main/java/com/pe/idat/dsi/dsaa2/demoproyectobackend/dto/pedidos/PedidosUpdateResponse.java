package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidosUpdateResponse {

    private Long pedidoId;
    private Long cliente;
    private Date fecha;
    private double total;
    private String estado;

    public static PedidosUpdateResponse toPedidosUpdateResponse(Pedidos pedido){
        return new PedidosUpdateResponse(pedido.getPedidoId(), 
        pedido.getCliente().getClienteId(), 
        pedido.getFecha(), 
        pedido.getTotal(), 
        pedido.getEstado());
    }

}
