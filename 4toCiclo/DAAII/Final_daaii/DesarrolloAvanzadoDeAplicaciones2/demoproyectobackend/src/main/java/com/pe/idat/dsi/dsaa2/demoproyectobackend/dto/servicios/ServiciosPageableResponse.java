package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios;

import java.util.List;

import org.springframework.data.domain.Page;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServiciosPageableResponse {
    private int totalItems;
    private int totalPages;
    
    private List<ServiciosPageableItemResponse> items;

    public static ServiciosPageableResponse toServiciosPageableResponse(Page<Servicios> servicios){
        return new ServiciosPageableResponse((int)servicios.getTotalElements(), 
        servicios.getTotalPages(), 
        servicios.getContent().stream().map(ServiciosPageableItemResponse::toServiciosPageableItemResponse).toList());
                                        }

}
