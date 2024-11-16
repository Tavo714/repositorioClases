package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class ServiciosInsertResponse {
    private Long servicioId;
    private String nombreServicio;
    private String descripcion;
    private double precio;
    private String estado; 

    public static ServiciosInsertResponse toServiciosInsertResponse(Servicios servicios){
        return new ServiciosInsertResponse( servicios.getServicioId(), 
                                            servicios.getNombreServicio(), 
                                            servicios.getDescripcion(), 
                                            servicios.getPrecio(),
                                            servicios.getEstado());                                   
    }
}
