package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;


@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    @Query(value = " SELECT c FROM Clientes c WHERE c.estado = '1' ")
    List<Clientes> findAllActiveClientes(Sort sorting);

    @Query("SELECT c FROM Clientes c WHERE estado = '1' and (c.nombreCliente LIKE %:filter% OR c.direccion LIKE %:filter% OR c.email LIKE %:filter%)")
    Page<Clientes> findAllPageableActiveClientes(Pageable pageable, @Param("filter") String filter);
 
    @Query(value = " SELECT * FROM Clientes c WHERE c.estado = '0' ", nativeQuery = true)
    List<Clientes> findAllActiveClientesNative();
}
