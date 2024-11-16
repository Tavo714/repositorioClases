package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.proveedores.ProveedoresSorting;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Proveedores;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.ProveedoresRepository;

@Service
public class ProveedoresService {

    private ProveedoresRepository proRepository;

    public ProveedoresService(ProveedoresRepository proRepository){
        this.proRepository = proRepository;
    }

    public List<Proveedores> getAll(){
        return proRepository.findAll();

    }
    public List<Proveedores> getAll(ProveedoresSorting sorting){
        Sort userSorting = Sort.by(sorting.getDirecction().equals("asc")? Direction.ASC: Direction.DESC,sorting.getColumnOrder());
        return proRepository.findAllActiveProveedores(userSorting);
    }

    public Page<Proveedores> getAllPageable(ProveedoresPageable pageable){
            Sort proveedorSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC,pageable.getColumnOrder());
            Pageable proveedoresPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), proveedorSorting);
            return proRepository.findAllPageableActiveProveedores(proveedoresPageable, pageable.getFilter());
            
            
    }

    
    public Proveedores insertProveedores(Proveedores entity) {
        Proveedores response = proRepository.saveAndFlush(entity);
        if (response.getProveedorId() == null || response.getProveedorId() == 0) {
            return null;
        }
        return response;
    }

    public Proveedores getById(Long id) {
        Optional<Proveedores> response = proRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }

    public Proveedores updateProveedores(Proveedores entity) {
        Optional<Proveedores> response = proRepository.findById(entity.getProveedorId());
        if(!response.isPresent()){
            return null;
        }
        Proveedores entityToUpdate=response.get();
        entityToUpdate = entityToUpdate.updatePropierties(entity);
        entityToUpdate = proRepository.saveAndFlush(entityToUpdate);
        return entityToUpdate;
    }
    
    public boolean deleteProveedores(Long id){
        proRepository.deleteById(id);
        return true;
    }
}
