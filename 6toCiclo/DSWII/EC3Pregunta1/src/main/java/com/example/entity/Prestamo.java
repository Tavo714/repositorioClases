package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroprestamo;

    private LocalDate fechaPrestamo;
    private double importe;
    private int nroCuotas;
    private double interes;

    @ManyToOne
    @JoinColumn(name = "dnicliente", nullable = false)
    @JsonBackReference
    private Cliente cliente;

	public Prestamo() {
		super();
	}

	public Prestamo(Long nroprestamo, LocalDate fechaPrestamo, double importe, int nroCuotas, double interes,
			Cliente cliente) {
		super();
		this.nroprestamo = nroprestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.importe = importe;
		this.nroCuotas = nroCuotas;
		this.interes = interes;
		this.cliente = cliente;
	}

	public Long getNroprestamo() {
		return nroprestamo;
	}

	public void setNroprestamo(Long nroprestamo) {
		this.nroprestamo = nroprestamo;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(int nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    // Getters y setters (o usa @Data de Lombok si lo tienes activado)
    
    
}
