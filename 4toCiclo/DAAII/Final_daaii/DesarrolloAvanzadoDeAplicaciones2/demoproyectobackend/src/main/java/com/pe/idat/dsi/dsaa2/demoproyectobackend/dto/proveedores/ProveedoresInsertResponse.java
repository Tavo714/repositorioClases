package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedoresInsertResponse {

    private Long proveedorId;
    private String nombreProveedor;
    private String direccion;
    private String email;
    private String telefono;
    private String estado; 

    public static ProveedoresInsertResponse toProveedoresInsertResponse(Proveedores proveedores){
        return new ProveedoresInsertResponse(  proveedores.getProveedorId(), 
        proveedores.getNombreProveedor(), 
        proveedores.getDireccion(), 
        proveedores.getEmail(), 
        proveedores.getTelefono(), 
        proveedores.getEstado());                                   
    }
}
