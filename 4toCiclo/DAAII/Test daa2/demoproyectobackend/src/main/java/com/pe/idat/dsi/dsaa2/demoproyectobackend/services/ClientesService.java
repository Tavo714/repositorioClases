package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes.ClientesSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.ClientesRepository;

@Service
public class ClientesService {

    private ClientesRepository cRepository;

    public ClientesService(ClientesRepository cRepository){
        this.cRepository = cRepository;
    }

    public List<Clientes> getAll(){
        return cRepository.findAll();

    }
    public List<Clientes> getAll(ClientesSorting sorting){
        Sort userSorting = Sort.by(sorting.getDirecction().equals("asc")? Direction.ASC: Direction.DESC,sorting.getColumnOrder());
        return cRepository.findAllActiveClientes(userSorting);
    }

    public Page<Clientes> getAllPageable(ClientesPageable pageable){
            Sort clienteSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC,pageable.getColumnOrder());
            Pageable clientesPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), clienteSorting);
            return cRepository.findAllPageableActiveClientes(clientesPageable, pageable.getFilter());
            
            
    }

    
    public Clientes insertCliente(Clientes entity) {
        Clientes response = cRepository.saveAndFlush(entity);
        if (response.getClienteId() == null || response.getClienteId() == 0) {
            return null;
        }
        return response;
    }

    public Clientes getById(Long id) {
        Optional<Clientes> response = cRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }

    public Clientes updateCliente(Clientes entity) {
        Optional<Clientes> response = cRepository.findById(entity.getClienteId());
        if(!response.isPresent()){
            return null;
        }
        Clientes entityToUpdate=response.get();
        entityToUpdate = entityToUpdate.updatePropierties(entity);
        entityToUpdate = cRepository.saveAndFlush(entityToUpdate);
        return entityToUpdate;
    }
    
    public boolean deleteCliente(Long id){
        cRepository.deleteById(id);
        return true;
    }
}
