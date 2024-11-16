package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosPageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.productos.ProductosSorting;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.ProductosRepository;

@Service
public class ProductosService {
    
    private ProductosRepository pRepository;

    public ProductosService(ProductosRepository pRepository){
        this.pRepository = pRepository;
    }

    public List<Productos> getAll(){
        return pRepository.findAll();

    }
    public List<Productos> getAll(ProductosSorting sorting){
        Sort productosSorting = Sort.by(sorting.getDirecction().equals("asc")? Direction.ASC: Direction.DESC,sorting.getColumnOrder());
        return pRepository.findAllActiveProductos(productosSorting);
    }

    public Page<Productos> getAllPageable(ProductosPageable pageable){
            Sort productosSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC,pageable.getColumnOrder());
            Pageable productosPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), productosSorting);
            return pRepository.findAllPageableActiveProductos(productosPageable, pageable.getFilter());                
    }
    
    public Productos insertProductos(Productos entity) {
        Productos response = pRepository.saveAndFlush(entity);
        if (response.getProductoId() == null || response.getProductoId() == 0) {
            return null;
        }
        return response;
    }

    public Productos getById(Long id) {
        Optional<Productos> response = pRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }

    public Productos updateProductos(Productos entity) {
        Optional<Productos> response = pRepository.findById(entity.getProductoId());
        if(!response.isPresent()){
            return null;
        }
        Productos entityToUpdate=response.get();
        entityToUpdate = entityToUpdate.updatePropierties(entity);
        entityToUpdate = pRepository.saveAndFlush(entityToUpdate);
        return entityToUpdate;
    }
    
    public boolean deleteProductos(Long id){
        pRepository.deleteById(id);
        return true;
    }

}
