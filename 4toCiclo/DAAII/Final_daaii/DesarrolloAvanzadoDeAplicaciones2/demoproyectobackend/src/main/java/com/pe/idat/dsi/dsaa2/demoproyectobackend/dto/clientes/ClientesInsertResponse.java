package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientesInsertResponse {

    private Long clienteId;
    private String nombreCliente;
    private String direccion;
    private String email;
    private String telefono;
    private String estado; 

    public static ClientesInsertResponse toClientesInsertResponse(Clientes clientes){
        return new ClientesInsertResponse(  clientes.getClienteId(), 
                                            clientes.getNombreCliente(), 
                                            clientes.getDireccion(), 
                                            clientes.getEmail(), 
                                            clientes.getTelefono(), 
                                            clientes.getEstado());                                   
    }
}
