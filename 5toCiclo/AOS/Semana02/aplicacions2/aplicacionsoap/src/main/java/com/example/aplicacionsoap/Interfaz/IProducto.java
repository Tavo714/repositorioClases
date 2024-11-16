package com.example.aplicacionsoap.Interfaz;

import org.springframework.data.repository.CrudRepository;

import com.example.aplicacionsoap.Modelo.CProducto;

public interface IProducto extends CrudRepository<CProducto, Long> {

}
