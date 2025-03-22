package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Cliente {

    @Id
    private String dnicliente;

    private String apellidos;
    private String nombre;
    private String domicilio;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;

    private String clave;
    private boolean estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Prestamo> prestamos;

	public Cliente() {
		super();
	}

	public Cliente(String dnicliente, String apellidos, String nombre, String domicilio, LocalDate fechaNacimiento,
			LocalDate fechaRegistro, String clave, boolean estado, List<Prestamo> prestamos) {
		super();
		this.dnicliente = dnicliente;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
		this.clave = clave;
		this.estado = estado;
		this.prestamos = prestamos;
	}

	public String getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	} 
    
}
