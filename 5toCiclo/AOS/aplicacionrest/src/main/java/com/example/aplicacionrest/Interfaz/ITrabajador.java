package com.example.aplicacionrest.Interfaz;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.aplicacionrest.Modelo.CTrabajador;

public interface ITrabajador extends CrudRepository<CTrabajador, Integer>{

    Optional<CTrabajador> findBydnitra(String dni);
    Optional<CTrabajador> findByteltra(String telefono);

}
