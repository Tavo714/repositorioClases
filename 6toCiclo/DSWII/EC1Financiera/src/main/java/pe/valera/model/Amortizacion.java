package pe.valera.model;

import java.io.Serializable;
import java.util.Date;

public class Amortizacion implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private Integer amorNum;
	private Date amorFecha;
	private Integer prestaNum;
	private Date prestaFecha;	
	private String dniCliente;
	private double capitalImp;
	private double interesImp;
	private double amorTotal;
	
	public Amortizacion() {}
	
	public Amortizacion(Amortizacion amortizacion) {
		this(amortizacion.getPrestaNum(), 
				amortizacion.getPrestaFecha(), 
				amortizacion.getAmorNum(),
				amortizacion.getAmorFecha(),
				amortizacion.getDniCliente(),
				amortizacion.getCapitalImp(),
				amortizacion.getInteresImp(),
				amortizacion.getAmorTotal());
	}


	public Amortizacion(Integer prestaNum, Date prestaFecha, Integer amorNum, Date amorFecha, String dniCliente,
			double capitalImp, double interesImp, double amorTotal) {
		super();
		this.prestaNum = prestaNum;
		this.prestaFecha = prestaFecha;
		this.amorNum = amorNum;
		this.amorFecha = amorFecha;
		this.dniCliente = dniCliente;
		this.capitalImp = capitalImp;
		this.interesImp = interesImp;
		this.amorTotal = amorTotal;
	}

	public Integer getPrestaNum() {
		return prestaNum;
	}

	public void setPrestaNum(Integer prestaNum) {
		this.prestaNum = prestaNum;
	}

	public Date getPrestaFecha() {
		return prestaFecha;
	}

	public void setPrestaFecha(Date prestaFecha) {
		this.prestaFecha = prestaFecha;
	}

	public Integer getAmorNum() {
		return amorNum;
	}

	public void setAmorNum(Integer amorNum) {
		this.amorNum = amorNum;
	}

	public Date getAmorFecha() {
		return amorFecha;
	}

	public void setAmorFecha(Date amorFecha) {
		this.amorFecha = amorFecha;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public double getCapitalImp() {
		return capitalImp;
	}

	public void setCapitalImp(double capitalImp) {
		this.capitalImp = capitalImp;
	}

	public double getInteresImp() {
		return interesImp;
	}

	public void setInteresImp(double interesImp) {
		this.interesImp = interesImp;
	}

	public double getAmorTotal() {
		return amorTotal;
	}

	public void setAmorTotal(double amorTotal) {
		this.amorTotal = amorTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
