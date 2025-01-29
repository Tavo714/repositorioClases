package pe.company.model;

import java.io.Serializable;
import java.util.Date;

public class Prestamo implements Serializable{
	
	private static final long serialVersionUID=1L;
	private Integer nroPrestamo;
	private Date fecha;
	private String financista;
	private String cliente;
	private double importe;
	private Integer nroLetras;
	private double interes;
	
	public Prestamo() {
	}
	
	public Prestamo(Prestamo prestamo) {
		this(prestamo.getNroPrestamo(), 
				prestamo.getFecha(), 
				prestamo.getFinancista(),
				prestamo.getCliente(),
				prestamo.getImporte(),
				prestamo.getNroLetras(),
				prestamo.getInteres());
	}

	public Prestamo(Integer nroPrestamo, Date fecha, String financista, String cliente, double importe,
			Integer nroLetras, double interes) {

		this.nroPrestamo = nroPrestamo;
		this.fecha = fecha;
		this.financista = financista;
		this.cliente = cliente;
		this.importe = importe;
		this.nroLetras = nroLetras;
		this.interes = interes;
	}

	public Integer getNroPrestamo() {
		return nroPrestamo;
	}

	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFinancista() {
		return financista;
	}

	public void setFinancista(String financista) {
		this.financista = financista;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Integer getNroLetras() {
		return nroLetras;
	}

	public void setNroLetras(Integer nroLetras) {
		this.nroLetras = nroLetras;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
