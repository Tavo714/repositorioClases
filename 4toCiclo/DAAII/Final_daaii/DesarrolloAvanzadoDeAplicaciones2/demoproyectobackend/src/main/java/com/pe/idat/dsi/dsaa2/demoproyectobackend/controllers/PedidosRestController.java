package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosGetByIdResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosInsertResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosPageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosSorting;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.PedidosService;

@RestController
@RequestMapping("api/v1/pedidos")
public class PedidosRestController {
    private PedidosService pedidosService;
    

    public PedidosRestController(PedidosService pedidosService){
        this.pedidosService = pedidosService;
    }

    @GetMapping()
    public List<Pedidos> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        PedidosSorting sorting = new PedidosSorting(columnOrder, direction);
        return pedidosService.getAll(sorting);
    }

    //Obtener todos los pedidos
    @GetMapping("/page")
    public ResponseEntity<PedidosPageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        PedidosPageable pageable = new PedidosPageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<Pedidos> response = pedidosService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(PedidosPageableResponse.toPedidosPageableResponse(response));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PedidosGetByIdResponse> getById(@PathVariable Long id) {
        Pedidos pedido = pedidosService.getById(id);
        if (pedido == null || pedido.getPedidoId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PedidosGetByIdResponse.toPedidosGetByIdResponse(pedido));
    }
    
    

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidosInsertResponse> insertPedidos(@RequestBody PedidosInsertRequest entity) {
        
        try {
            Pedidos savePedidos = pedidosService.insertPedidos(entity);

            if (savePedidos == null || savePedidos.getPedidoId() == 0) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(PedidosInsertResponse.toPedidosInsertResponse(savePedidos));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PedidosInsertResponse(null, null, null, 0, "Ocurrió un error: " + ex.getMessage()));
        }
    }

    
    
}