package pe.company.model;

import java.io.Serializable;
import java.util.Date;

public class Proyecto implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private Integer codProyecto;
	private String nombre;
	private String ubicacion;
	private String municipalidad;
	private Date fecaprobacion;
	private Date fecinicio;
	private double inversion;
	private int tiempodesarrollo;
	private String responsable;
	private String financiera;
	private String descripcion;
	
	public Proyecto() {
	}
	
	public Proyecto(Proyecto proyecto) {
		this(proyecto.getCodProyecto(), 
				proyecto.getNombre(), 
				proyecto.getUbicacion(),
				proyecto.getMunicipalidad(),
				proyecto.getFecaprobacion(),
				proyecto.getFecinicio(),
				proyecto.getInversion(),
				proyecto.getTiempodesarrollo(),
				proyecto.getResponsable(),
				proyecto.getFinanciera(),
				proyecto.getDescripcion()			
				);
	}

	public Proyecto(Integer codProyecto, String nombre, String ubicacion, String municipalidad, Date fecaprobacion,
			Date fecinicio, double inversion, int tiempodesarrollo, String responsable, String financiera,
			String descripcion) {

		this.codProyecto = codProyecto;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.municipalidad = municipalidad;
		this.fecaprobacion = fecaprobacion;
		this.fecinicio = fecinicio;
		this.inversion = inversion;
		this.tiempodesarrollo = tiempodesarrollo;
		this.responsable = responsable;
		this.financiera = financiera;
		this.descripcion = descripcion;
	}

	public Integer getCodProyecto() {
		return codProyecto;
	}

	public void setCodProyecto(Integer codProyecto) {
		this.codProyecto = codProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getMunicipalidad() {
		return municipalidad;
	}

	public void setMunicipalidad(String municipalidad) {
		this.municipalidad = municipalidad;
	}

	public Date getFecaprobacion() {
		return fecaprobacion;
	}

	public void setFecaprobacion(Date fecaprobacion) {
		this.fecaprobacion = fecaprobacion;
	}

	public Date getFecinicio() {
		return fecinicio;
	}

	public void setFecinicio(Date fecinicio) {
		this.fecinicio = fecinicio;
	}

	public double getInversion() {
		return inversion;
	}

	public void setInversion(double inversion) {
		this.inversion = inversion;
	}

	public int getTiempodesarrollo() {
		return tiempodesarrollo;
	}

	public void setTiempodesarrollo(int tiempodesarrollo) {
		this.tiempodesarrollo = tiempodesarrollo;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getFinanciera() {
		return financiera;
	}

	public void setFinanciera(String financiera) {
		this.financiera = financiera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
