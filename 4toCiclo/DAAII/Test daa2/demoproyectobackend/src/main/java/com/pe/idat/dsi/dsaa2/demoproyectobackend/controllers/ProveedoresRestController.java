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

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesGetByIdResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesInsertResponse;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesPageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesUpdateRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesUpdateResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresGetByIdResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresInsertResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresPageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresUpdateRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresUpdateResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ClientesService;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ProveedoresService;



@RestController
@RequestMapping("api/v1/proveedores")
public class ProveedoresRestController {

    private ProveedoresService proveedoresService;

    public ProveedoresRestController(ProveedoresService proveedoresService){
        this.proveedoresService = proveedoresService;
    }

    @GetMapping()
    public List<Proveedores> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        ProveedoresSorting sorting = new ProveedoresSorting(columnOrder, direction);
        return proveedoresService.getAll(sorting);
    }
    @GetMapping("/page")
    public ResponseEntity<ProveedoresPageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        ProveedoresPageable pageable = new ProveedoresPageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<Proveedores> response = proveedoresService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ProveedoresPageableResponse.toProveedoresPageableResponse(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedoresGetByIdResponse> getById(@PathVariable Long id) {
        Proveedores proveedores = proveedoresService.getById(id);
        if (proveedores == null || proveedores.getProveedorId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProveedoresGetByIdResponse.toProveedoresGetByIdResponse(proveedores));
    }
    
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedoresInsertResponse> insertProveedores(@RequestBody ProveedoresInsertRequest entity) {
        Proveedores proveedores = proveedoresService.insertProveedores(ProveedoresInsertRequest.toProveedores(entity));
        if (proveedores == null || proveedores.getProveedorId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ProveedoresInsertResponse.toProveedoresInsertResponse(proveedores));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedoresUpdateResponse> updateProveedores(@PathVariable Long id, @RequestBody ProveedoresUpdateRequest entity) {
        entity.setProveedorId(id);
        Proveedores proveedores = proveedoresService.updateProveedores(ProveedoresUpdateRequest.toProveedores(entity));
        if(proveedores == null){
            return ResponseEntity.badRequest().build();
        }
        if(proveedores.getProveedorId() == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ProveedoresUpdateResponse.toProveedoresUpdateResponse(proveedores));
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteProveedores(@PathVariable Long id)    
    {
        boolean hasDeleted = proveedoresService.deleteProveedores(id);
        if(!hasDeleted){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok( "El Proveedor ha sido eliminado correctamente");
    }
    

}
