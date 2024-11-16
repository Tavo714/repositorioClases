package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProveedoresPageable {
    
    private int pageNumber;
    private int pageSize;
    private String columnOrder;
    private String direction;
    private String filter;
    
}
