package com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Long>{

    @Query(value = " SELECT s FROM Servicios s WHERE s.estado = '1' ")
    List<Servicios> findAllActiveServicios(Sort sorting);

    @Query("SELECT s FROM Servicios s WHERE s.estado = '1' and (s.nombreServicio LIKE %:filter%)")
    Page<Servicios> findAllPageableActiveServicios(Pageable pageable, @Param("filter") String filter);
 
    @Query(value = " SELECT * FROM Servicios s WHERE s.estado = '0' ", nativeQuery = true)
    List<Servicios> findAllActiveServiciosNative();

}
