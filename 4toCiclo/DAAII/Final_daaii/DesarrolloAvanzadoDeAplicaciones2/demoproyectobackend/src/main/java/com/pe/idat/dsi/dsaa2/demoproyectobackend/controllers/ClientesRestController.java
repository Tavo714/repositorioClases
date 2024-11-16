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
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ClientesService;



@RestController
@RequestMapping("api/v1/clientes")
public class ClientesRestController {

    private ClientesService clientesService;

    public ClientesRestController(ClientesService clientesService){
        this.clientesService = clientesService;
    }

    @GetMapping()
    public List<Clientes> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        ClientesSorting sorting = new ClientesSorting(columnOrder, direction);
        return clientesService.getAll(sorting);
    }
    @GetMapping("/page")
    public ResponseEntity<ClientesPageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        ClientesPageable pageable = new ClientesPageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<Clientes> response = clientesService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ClientesPageableResponse.toClientesPageableResponse(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesGetByIdResponse> getById(@PathVariable Long id) {
        Clientes cliente = clientesService.getById(id);
        if (cliente == null || cliente.getClienteId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ClientesGetByIdResponse.toClientesGetByIdResponse(cliente));
    }
    
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientesInsertResponse> insertClientes(@RequestBody ClientesInsertRequest entity) {
        Clientes cliente = clientesService.insertCliente(ClientesInsertRequest.toClientes(entity));
        if (cliente == null || cliente.getClienteId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ClientesInsertResponse.toClientesInsertResponse(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesUpdateResponse> updateClientes(@PathVariable Long id, @RequestBody ClientesUpdateRequest entity) {
        entity.setClienteId(id);
        Clientes cliente = clientesService.updateCliente(ClientesUpdateRequest.toClientes(entity));
        if(cliente == null){
            return ResponseEntity.badRequest().build();
        }
        if(cliente.getClienteId() == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ClientesUpdateResponse.toClientesUpdateResponse(cliente));
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteCliente(@PathVariable Long id)    
    {
        boolean hasDeleted = clientesService.deleteCliente(id);
        if(!hasDeleted){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok( "El usuario ha sido eliminado correctamente");
    }
    

}
