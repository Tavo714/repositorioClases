package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.pedidos.PedidosSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.PedidosRepository;

@Service
public class PedidosService {
    private PedidosRepository peRepository;
    private ClientesService clientesService;
    private DetallePedidosService detallePedidosService; // Asegúrate de que esto esté inyectado correctamente

    @Autowired
    public PedidosService(PedidosRepository peRepository, ClientesService clientesService, DetallePedidosService detallePedidosService){
        this.peRepository = peRepository;
        this.clientesService = clientesService;
        this.detallePedidosService = detallePedidosService;
    }
    
    public PedidosService(DetallePedidosService detallePedidosService){
        this.detallePedidosService = detallePedidosService;
    }
   
   

    public List<Pedidos> getAll() {
        return peRepository.findAll();
    }
    public List<Pedidos> getAll(PedidosSorting sorting){
        Sort pedidosSorting = Sort.by(sorting.getDirection().equals("asc")? Direction.ASC:Direction.DESC, sorting.getColumnOrder());
        return peRepository.findAllActivePedidos(pedidosSorting);
    
    }
    public Page<Pedidos> getAllPageable(PedidosPageable pageable){
        Sort pedidoSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC, pageable.getColumnOrder());
        Pageable pedidoPageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), pedidoSorting);
        return peRepository.findAllPageableActivePedidos(pedidoPageable, pageable.getFilter());
    }
    
    public Pedidos getById(Long id) {
        Optional<Pedidos> response = peRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }


    public Pedidos insertPedidos(PedidosInsertRequest entity){
        // Obtén el cliente usando el servicio
        Clientes cliente = clientesService.getById(entity.getClienteId());
        // Verifica que cliente no sea null
        if (cliente == null) {
            return null;
        }
        // Obtén la fecha y hora actual usando LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        //Establece la fecha actual en el pedido
        entity.setFecha(currentDate);
        entity.setEstado("1");

        // Convertir DTO a entidad relacional
        Pedidos pedido = entity.toPedidos(cliente);

        // Guarda el detalle en la base de datos
        Pedidos response = peRepository.saveAndFlush(pedido);

        // Verifica si el pedido se guardó correctamente
        if (response.getPedidoId() == null || response.getPedidoId() == 0) {
            return null;
        }
        for (DetalleInsertRequest detalleRequest : entity.getDetalles()) {
            // Establece el ID del pedido en cada detalle
            detalleRequest.setPedidoId(pedido.getPedidoId());
            detallePedidosService.insertDetalle(detalleRequest); 
        }

        return response;
    }
    

}
