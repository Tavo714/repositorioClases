package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProveedoresPageableResponse {
    private int totalItems;
    private int totalPages;
    
    private List<ProveedoresPageableItemResponse> items;

    public static ProveedoresPageableResponse toProveedoresPageableResponse(Page<Proveedores> proveedores){
        return new ProveedoresPageableResponse((int)proveedores.getTotalElements(), 
        proveedores.getTotalPages(), 
        proveedores.getContent().stream().map(ProveedoresPageableItemResponse::toProveedoresPageableItemResponse).toList());
                                        }
}
