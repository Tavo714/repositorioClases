package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PedidosPageableResponse {
    private int totalItems;
    private int totalPages;
    private List<PedidosPageableItemResponse> items;
    public static PedidosPageableResponse toPedidosPageableResponse(Page<Pedidos> pedido){
        return new PedidosPageableResponse((int)pedido.getTotalElements(),
        pedido.getTotalPages(), 
        pedido.getContent().stream().map(PedidosPageableItemResponse::toPedidosPageableItemResponse).toList());
    }
}
