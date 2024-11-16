package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

    @Query(value = " SELECT pe FROM Pedidos  pe WHERE pe.estado = '1' ")
    List<Pedidos> findAllActivePedidos(Sort sorting);

    @Query("SELECT pe FROM Pedidos pe WHERE estado = '1' and (pe.estado LIKE %:filter%)")
    Page<Pedidos> findAllPageableActivePedidos(Pageable pageable, @Param("filter") String filter);

}
