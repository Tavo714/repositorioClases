package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PedidosPageable {

    private int pageNumber;
    private int pageSize;
    private String columnOrder;
    private String direction;
    private String filter;
    
}
