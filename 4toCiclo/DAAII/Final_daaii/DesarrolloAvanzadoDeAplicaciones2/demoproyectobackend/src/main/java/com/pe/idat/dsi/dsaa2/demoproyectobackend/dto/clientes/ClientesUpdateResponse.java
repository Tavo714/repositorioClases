package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientesUpdateResponse {
    private Long clienteId;
    private String nombreCliente;
    private String direccion;
    private String usuario;
    private String clave;
    private String email;
    private String telefono;
    private String estado; 

    public static ClientesUpdateResponse toClientesUpdateResponse(Clientes clientes) {
        return new ClientesUpdateResponse(
            clientes.getClienteId(), 
            clientes.getNombreCliente(),
            clientes.getDireccion(),
            clientes.getUsuario(), 
            clientes.getClave(),
            clientes.getEmail(), 
            clientes.getTelefono(), 
            clientes.getEstado()
        );                                  
    }
}
