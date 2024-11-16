package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidos, Long>{
    @Query(value = " SELECT d FROM DetallePedidos  d WHERE d.estado = '1' ")
    List<DetallePedidos> findAllActiveDetalles(Sort sorting);

    @Query("SELECT d FROM DetallePedidos d WHERE estado = '1' and (d.estado LIKE %:filter%)")
    Page<DetallePedidos> findAllPageableActiveDetalles(Pageable pageable, @Param("filter") String filter);
    //Obtener de la bd solo los detalles segun el cliente
    @Query("SELECT d FROM DetallePedidos d WHERE d.pedido.cliente.clienteId = :clienteId AND d.estado = '1'")
    Page<DetallePedidos> findByPedido_Cliente_ClienteId(@Param("clienteId") Long clienteId, Pageable pageable);
}
