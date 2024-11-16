package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedoresPageableItemResponse {

    private Long proveedorId;
    private String nombreProveedor;
    private String direccion;
    private String email;
    private String telefono;
    private String estado; 

    public static ProveedoresPageableItemResponse toProveedoresPageableItemResponse(Proveedores proveedores){
        return new ProveedoresPageableItemResponse(proveedores.getProveedorId(), 
        proveedores.getNombreProveedor(), 
        proveedores.getDireccion(), 
        proveedores.getEmail(),
        proveedores.getTelefono(), 
        proveedores.getEstado());
        
    }
}
