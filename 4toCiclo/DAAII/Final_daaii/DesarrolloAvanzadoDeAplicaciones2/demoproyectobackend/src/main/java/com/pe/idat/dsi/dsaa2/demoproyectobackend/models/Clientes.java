package com.pe.idat.dsi.dsaa2.demoproyectobackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "username")
    private String usuario;
    @Column(name = "password")
    private String clave;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "estado")
    private String estado;

    public Clientes(Long clienteId, String nombreCliente, String direccion, String email, String usuario, String clave, String telefono) {
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
        this.email = email;
        this.telefono = telefono;
    }
    public Clientes updatePropierties(Clientes model){
        nombreCliente = model.nombreCliente;
        direccion = model.direccion;
        email =model.email;
        usuario = model.usuario;
        clave = model.clave;
        telefono = model.telefono;
        return this;
    }

    

}