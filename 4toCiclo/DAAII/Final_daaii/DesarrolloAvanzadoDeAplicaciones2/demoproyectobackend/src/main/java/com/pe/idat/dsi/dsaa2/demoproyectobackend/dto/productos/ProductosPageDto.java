package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos;

import java.util.List;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ProductosPageDto {
    private int totalItems;
    private int pageNumber;
    private int totalPages;
    private int pageSize;
    private List<Productos> items;
}
