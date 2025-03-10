package pe.company.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codmed;
	
	@Column
	private String nommed;
	@Column
	private String labmed;
	@Column
	private double premed;
	@Column
	private int stomed;
	
	public Medicamento() {
		
	}

	public Medicamento(Integer codmed, String nommed, String labmed, double premed, int stomed) {
		super();
		this.codmed = codmed;
		this.nommed = nommed;
		this.labmed = labmed;
		this.premed = premed;
		this.stomed = stomed;
	}

	public Integer getCodmed() {
		return codmed;
	}

	public void setCodmed(Integer codmed) {
		this.codmed = codmed;
	}

	public String getNommed() {
		return nommed;
	}

	public void setNommed(String nommed) {
		this.nommed = nommed;
	}

	public String getLabmed() {
		return labmed;
	}

	public void setLabmed(String labmed) {
		this.labmed = labmed;
	}

	public double getPremed() {
		return premed;
	}

	public void setPremed(double premed) {
		this.premed = premed;
	}

	public int getStomed() {
		return stomed;
	}

	public void setStomed(int stomed) {
		this.stomed = stomed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
