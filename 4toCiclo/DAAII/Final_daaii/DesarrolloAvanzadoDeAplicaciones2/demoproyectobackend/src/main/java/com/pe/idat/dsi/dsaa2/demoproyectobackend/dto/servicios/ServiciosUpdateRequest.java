package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiciosUpdateRequest {
    private Long servicioId;
    private String nombreServicio;
    private String descripcion;
    private double precio;
    private String estado; 

    public static Servicios toServicios(ServiciosUpdateRequest servicios) {
        return new Servicios(
            servicios.getServicioId(), 
            servicios.getNombreServicio(), 
            servicios.getDescripcion(), 
            servicios.getPrecio(), 
            servicios.getEstado()
        );                                  
    }
}
