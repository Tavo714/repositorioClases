package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long>{

    @Query(value = " SELECT p FROM Productos p WHERE p.estado = '1' ")
    List<Productos> findAllActiveProductos(Sort sorting);

    @Query("SELECT p FROM Productos p WHERE estado = '1' and (p.nombreProducto LIKE %:filter%)")
    Page<Productos> findAllPageableActiveProductos(Pageable pageable, @Param("filter") String filter);

    
    @Query(value = " SELECT * FROM Productos p WHERE p.estado = '0' ", nativeQuery = true)
    List<Productos> findAllActiveProductosNative();

}
