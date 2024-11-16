package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DetallePageableResponse {
    private int totalItems;
    private int totalPages;
    private List<DetallePageableItemResponse> items;
    public static DetallePageableResponse toDetallePageableResponse(Page<DetallePedidos> detallesPDto){
        return new DetallePageableResponse((int)detallesPDto.getTotalElements(),
                                            detallesPDto.getTotalPages(), 
                                    detallesPDto.getContent().stream().map(DetallePageableItemResponse::toDetallePageableItemResponse).toList());
    }
}
