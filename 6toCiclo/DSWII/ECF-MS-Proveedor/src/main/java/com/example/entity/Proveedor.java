package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razonSocial;
    private String direccion;
    private String telefono;
    private String correo;
    private String contacto;

    public Proveedor() {}

    public Proveedor(Long id, String razonSocial, String direccion, String telefono, String correo, String contacto) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto = contacto;
    }

    // Getters y Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getRazonSocial() { return razonSocial; }

    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getContacto() { return contacto; }

    public void setContacto(String contacto) { this.contacto = contacto; }
}
