package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios.ServiciosSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.ServiciosRepository;

@Service
public class ServiciosService {
    private ServiciosRepository sRepository;

    public ServiciosService(ServiciosRepository sRepository){
        this.sRepository = sRepository;
    }
    public List<Servicios> getAll(){
        return sRepository.findAll();
    }
    public List<Servicios> getAll(ServiciosSorting sorting){
        Sort serviciosSorting = Sort.by(sorting.getDirecction().equals("asc")? Direction.ASC: Direction.DESC,sorting.getColumnOrder());
        return sRepository.findAllActiveServicios(serviciosSorting);
    }
    public Page<Servicios> getAllPageable(ServiciosPageable pageable){
            Sort serviciosSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC,pageable.getColumnOrder());
            Pageable serviciosPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), serviciosSorting);
            return sRepository.findAllPageableActiveServicios(serviciosPageable, pageable.getFilter());                
    }
    public Servicios insertServicios(Servicios entity) {
        Servicios response = sRepository.saveAndFlush(entity);
        if (response.getServicioId() == null || response.getServicioId() == 0) {
            return null;
        }
        return response;
    }
    public Servicios updateServicios(Servicios entity) {
        Optional<Servicios> response = sRepository.findById(entity.getServicioId());
        if(!response.isPresent()){
            return null;
        }
        Servicios entityToUpdate=response.get();
        entityToUpdate = entityToUpdate.updatePropierties(entity);
        entityToUpdate = sRepository.saveAndFlush(entityToUpdate);
        return entityToUpdate;
    }
    public boolean deleteServicios(Long id){
        sRepository.deleteById(id);
        return true;
    }
    public Servicios getById(Long id) {
        Optional<Servicios> response = sRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }
       
}

