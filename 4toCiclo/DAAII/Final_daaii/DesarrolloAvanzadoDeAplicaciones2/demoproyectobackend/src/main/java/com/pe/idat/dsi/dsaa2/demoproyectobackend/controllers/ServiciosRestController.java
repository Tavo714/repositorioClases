package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosGetByIdResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosInsertResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosPageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosUpdateRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosUpdateResponse;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ServiciosService;

@RestController
@RequestMapping("api/v1/servicios")
public class ServiciosRestController {
    private ServiciosService serviciosService;

    public ServiciosRestController(ServiciosService serviciosService){
        this.serviciosService = serviciosService;
    }
    @GetMapping()
    public List<Servicios> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        ServiciosSorting sorting = new ServiciosSorting(columnOrder, direction);
        return serviciosService.getAll(sorting);
    }
    @GetMapping("/page")
    public ResponseEntity<ServiciosPageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        ServiciosPageable pageable = new ServiciosPageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<Servicios> response = serviciosService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ServiciosPageableResponse.toServiciosPageableResponse(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosGetByIdResponse> getById(@PathVariable Long id) {
        Servicios servicios = serviciosService.getById(id);
        if (servicios == null || servicios.getServicioId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ServiciosGetByIdResponse.toServiciosGetByIdResponse(servicios));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiciosInsertResponse> insertServicios(@RequestBody ServiciosInsertRequest entity) {
        Servicios servicios = serviciosService.insertServicios(ServiciosInsertRequest.toServicios(entity));
        if (servicios == null || servicios.getServicioId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ServiciosInsertResponse.toServiciosInsertResponse(servicios));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ServiciosUpdateResponse> updateServicios(@PathVariable Long id, @RequestBody ServiciosUpdateRequest entity) {
        entity.setServicioId(id);
        Servicios servicio = serviciosService.updateServicios(ServiciosUpdateRequest.toServicios(entity));
        if(servicio == null){
            return ResponseEntity.badRequest().build();
        }
        if(servicio.getServicioId() == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ServiciosUpdateResponse.toServiciosUpdateResponse(servicio));
    }
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteServicios(@PathVariable Long id)    
    {
        boolean hasDeleted = serviciosService.deleteServicios(id);
        if(!hasDeleted){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok( "El usuario ha sido eliminado correctamente");
    }
    
}
