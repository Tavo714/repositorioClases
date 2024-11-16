package com.pe.idat.dsi.dsaa2.demoproyectobackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicioId;

    @Column(name="nombre_servicio")
    private String nombreServicio;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio")
    private double precio;

    @Column(name="estado")
    private String estado;


    public Servicios(Long servicioId, String nombreServicio, String descripcion, double precio) {
        this.servicioId = servicioId;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        
        
    }
    public Servicios updatePropierties(Servicios model){
        nombreServicio = model.nombreServicio;
        descripcion = model.descripcion;
        precio =model.precio;
        return this;

    }
}
