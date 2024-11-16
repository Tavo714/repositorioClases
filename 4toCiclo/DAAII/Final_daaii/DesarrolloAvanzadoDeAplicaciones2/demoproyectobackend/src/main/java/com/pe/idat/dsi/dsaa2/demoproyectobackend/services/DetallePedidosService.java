package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetallePageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleUpdateRequest;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.DetallePedidosRepository;

@Service
public class DetallePedidosService {
    //REPOSITORIO DETALLE-P[E]DIDOS
    private DetallePedidosRepository dPedidosRepository;    
    private PedidosService pedidosService;
    private ProductosService productosService;
    @Autowired
    public DetallePedidosService( @Lazy PedidosService pedidosService, ProductosService productosService, DetallePedidosRepository dPedidosRepository){
        
        this.productosService = productosService;
        this.dPedidosRepository =dPedidosRepository;
        this.pedidosService = pedidosService;
    }

    public DetallePedidosService(DetallePedidosRepository dPedidosRepository){
        this.dPedidosRepository = dPedidosRepository;
    }
    
    public List<DetallePedidos> getAll() {
        return dPedidosRepository.findAll();
    }
    public List<DetallePedidos> getAll(DetalleSorting sorting){
        Sort detalleSorting = Sort.by(sorting.getDirection().equals("asc")? Direction.ASC:Direction.DESC, sorting.getColumnOrder());
        return dPedidosRepository.findAllActiveDetalles(detalleSorting);
    
    }
    public Page<DetallePedidos> getAllPageable(DetallePageable pageable){
        Sort detalleSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC, pageable.getColumnOrder());
        Pageable detallePageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), detalleSorting);
        return dPedidosRepository.findAllPageableActiveDetalles(detallePageable, pageable.getFilter());
    }
    public DetallePedidos getById(Long id){
        Optional<DetallePedidos> response = dPedidosRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }
    //Obtener detalle de pedidos segun el cliente
    public Page<DetallePedidos> getDetallesByCliente(Long clienteId, DetallePageable pageable) {
        Sort detalleSorting = Sort.by(pageable.getDirection().equals("asc") ? Direction.ASC : Direction.DESC, pageable.getColumnOrder());
        Pageable detallePageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), detalleSorting);
        return dPedidosRepository.findByPedido_Cliente_ClienteId(clienteId, detallePageable);
    }


    public DetallePedidos insertDetalle(DetalleInsertRequest entity){
        // Obtén el Pedido y Producto usando los servicios
        Pedidos pedido = pedidosService.getById(entity.getPedidoId());
        Productos producto = productosService.getById(entity.getProductoId());

        // Verifica que Pedido y Producto no sean null
        if (pedido == null || producto == null) {
            return null;
        }

        // Asigna el precio unitario desde el Producto
        entity.setPrecioUnitario(producto.getPrecio());
        entity.setEstado("1");

        // Convertir DTO a entidad relacional
        DetallePedidos detalle = entity.toDetallePedidos(pedido, producto);

        // Guarda el detalle en la base de datos
        DetallePedidos response = dPedidosRepository.saveAndFlush(detalle);

        // Verifica si el detalle se guardó correctamente
        if (response.getDetalleId() == null || response.getDetalleId() == 0) {
            return null;
        }

        return response;
    }

    public DetallePedidos updaDetallePedidos(DetalleUpdateRequest entity){
        Pedidos pedido = pedidosService.getById(entity.getPedidoId());
        Productos producto = productosService.getById(entity.getProductoId());
        
        if (pedido == null || producto == null) {
            return null;
        }

        entity.setPrecioUnitario(producto.getPrecio());
        entity.setEstado("1");

        DetallePedidos detalle = entity.toDetallePedidos(pedido, producto);
        Optional<DetallePedidos> response = dPedidosRepository.findById(detalle.getDetalleId());
        if (!response.isPresent()) 
        {
         return null;   
        }
        DetallePedidos entityToUpdate = response.get();
        entityToUpdate = entityToUpdate.updatePropierties(detalle);
        entityToUpdate = dPedidosRepository.saveAndFlush(entityToUpdate);
        return entityToUpdate;
    }
    public boolean deleteDetalle(Long id){
        
        //Eliminacion Logica para no afectar a las tablas relacionadas
        Optional<DetallePedidos> optionalDetalle = dPedidosRepository.findById(id);

        if (optionalDetalle.isPresent()) {
            DetallePedidos detalle = optionalDetalle.get();
            detalle.setEstado("0"); // Marca como eliminado
            dPedidosRepository.saveAndFlush(detalle); // Guarda el cambio en la base de datos
            return true;
        }

        return false;
        }
}