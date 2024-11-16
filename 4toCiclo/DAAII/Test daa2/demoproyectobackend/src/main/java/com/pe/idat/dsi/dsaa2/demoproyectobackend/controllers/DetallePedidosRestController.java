package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleGetByIDResponse;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetallePageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetallePageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleUpdateRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleUpdateResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.DetallePedidosService;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/v1/detalle-pedidos")
public class DetallePedidosRestController {
    private DetallePedidosService detallePedidosService;
    

    public DetallePedidosRestController(DetallePedidosService detallePedidosService){
        this.detallePedidosService = detallePedidosService;
    }

    @GetMapping()
    public List<DetallePedidos> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        DetalleSorting sorting = new DetalleSorting(columnOrder, direction);
        return detallePedidosService.getAll(sorting);
    }

    //Obtener todos los pedidos
    @GetMapping("/page")
    public ResponseEntity<DetallePageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        DetallePageable pageable = new DetallePageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<DetallePedidos> response = detallePedidosService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(DetallePageableResponse.toDetallePageableResponse(response));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalleGetByIDResponse> getById(@PathVariable Long id) {
        DetallePedidos detalle = detallePedidosService.getById(id);
        if (detalle == null || detalle.getDetalleId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(DetalleGetByIDResponse.toDetalleGetByIDResponse(detalle));
    }
    //Obtener pedidos segun el cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<DetallePageableResponse> getDetallesByCliente(
        @PathVariable Long clienteId,
        @RequestParam( required = false, defaultValue = "0") int pageNumber, 
        @RequestParam(required = false, defaultValue = "10") int pageSize,
        @RequestParam( required = false, defaultValue = "asc") String direction, 
        @RequestParam(required = false, defaultValue = "id") String columnOrder,
        @RequestParam(required = false, defaultValue = "") String filter)   {

        DetallePageable pageable = new DetallePageable(pageNumber, pageSize, columnOrder, direction, filter);
        Page<DetallePedidos> detalles = detallePedidosService.getDetallesByCliente(clienteId, pageable);
        if(detalles == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(DetallePageableResponse.toDetallePageableResponse(detalles));
    }

    
    /*@GetMapping("/{id}")
    public ResponseEntity<DetalleGetByIdViewResponse> getById(@PathVariable Long id) {
    DetallePedidos detalle = detallePedidosService.getById(id);
    if (detalle == null || detalle.getDetalleId() == 0) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(DetalleGetByIdViewResponse.fromDetallePedidos(detalle));
    }*/
    

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleInsertResponse> insertDetalle(@RequestBody DetalleInsertRequest entity) {
        
        try {
            DetallePedidos saveDetalle = detallePedidosService.insertDetalle(entity);

            if (saveDetalle == null || saveDetalle.getDetalleId() == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(DetalleInsertResponse.toDetalleInsertResponse(saveDetalle));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new DetalleInsertResponse(null, null, null, 0, 0, "Ocurrió un error: " + ex.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleUpdateResponse> updateDetalle(@PathVariable Long id, @RequestBody DetalleUpdateRequest entity) {
        entity.setDetalleId(id);

        DetallePedidos detalle = detallePedidosService.updaDetallePedidos(entity);
        if(detalle == null || detalle.getDetalleId()== 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(DetalleUpdateResponse.toDetalleUpdateResponse(detalle));
    }
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteDetalle(@PathVariable Long id)
    {
        boolean hasDeleted = detallePedidosService.deleteDetalle(id);
        if(!hasDeleted){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok( "El detalle ha sido eliminado correctamente");
    } 
    
}
