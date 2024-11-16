package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedoresUpdateResponse {
    private Long proveedorId;
    private String nombreProveedor;
    private String direccion;
    private String usuario;
    private String clave;
    private String email;
    private String telefono;
    private String estado; 

    public static ProveedoresUpdateResponse toProveedoresUpdateResponse(Proveedores proveedores) {
        return new ProveedoresUpdateResponse(
            proveedores.getProveedorId(), 
            proveedores.getNombreProveedor(),
            proveedores.getDireccion(),
            proveedores.getUsuario(), 
            proveedores.getClave(),
            proveedores.getEmail(), 
            proveedores.getTelefono(), 
            proveedores.getEstado()
        );                                  
    }
}
