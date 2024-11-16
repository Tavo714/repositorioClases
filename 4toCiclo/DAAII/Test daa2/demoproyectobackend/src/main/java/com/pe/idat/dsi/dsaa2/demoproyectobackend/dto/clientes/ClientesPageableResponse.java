package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientesPageableResponse {
    private int totalItems;
    private int totalPages;
    
    private List<ClientesPageableItemResponse> items;

    public static ClientesPageableResponse toClientesPageableResponse(Page<Clientes> clientesPDto){
        return new ClientesPageableResponse((int)clientesPDto.getTotalElements(), 
                                            clientesPDto.getTotalPages(), 
                                            clientesPDto.getContent().stream().map(ClientesPageableItemResponse::toClientesPageableItemResponse).toList());
                                        }
}
