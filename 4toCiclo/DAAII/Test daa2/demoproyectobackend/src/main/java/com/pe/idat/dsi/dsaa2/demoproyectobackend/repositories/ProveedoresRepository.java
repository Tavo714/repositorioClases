package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;


@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {
    @Query(value = " SELECT pro FROM Proveedores pro WHERE pro.estado = '1' ")
    List<Proveedores> findAllActiveProveedores(Sort sorting);

    @Query("SELECT pro FROM Proveedores pro WHERE estado = '1' and (pro.nombreProveedor LIKE %:filter% OR pro.direccion LIKE %:filter% OR pro.email LIKE %:filter%)")
    Page<Proveedores> findAllPageableActiveProveedores(Pageable pageable, @Param("filter") String filter);
 
    @Query(value = " SELECT * FROM Proveedores pro WHERE pro.estado = '0' ", nativeQuery = true)
    List<Proveedores> findAllActiveProveedoresNative();
}
