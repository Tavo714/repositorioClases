package pe.valera.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="proyectos")
public class Proyecto implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoPro;	
	@Column
	private String nombrePro;	
	@Column
	private String localPro;	
	@Column
	private String ingenieroPro;	
	@Column
	private Integer codigoAvancePro;
	@Temporal(TemporalType.DATE)
	private Date fechaAvancePro;
	@Column
	private String ingenieroResponsablePro;
	@Column
	private String descripcionAvancePro;
	@Column
	private String incidenciasPro;
	
	public Proyecto() {}
	
	public Proyecto(Proyecto proyecto) {
		this(proyecto.getCodigoPro(),
				proyecto.getNombrePro(),
				proyecto.getLocalPro(),
				proyecto.getIngenieroPro(),
				proyecto.getCodigoAvancePro(),
				proyecto.getFechaAvancePro(),
				proyecto.getIngenieroResponsablePro(),
				proyecto.getDescripcionAvancePro(),
				proyecto.getIncidenciasPro());
	}

	public Proyecto(Integer codigoPro, String nombrePro, String localPro, String ingenieroPro, Integer codigoAvancePro,
			Date fechaAvancePro, String ingenieroResponsablePro, String descripcionAvancePro, String incidenciasPro) {
		super();
		this.codigoPro = codigoPro;
		this.nombrePro = nombrePro;
		this.localPro = localPro;
		this.ingenieroPro = ingenieroPro;
		this.codigoAvancePro = codigoAvancePro;
		this.fechaAvancePro = fechaAvancePro;
		this.ingenieroResponsablePro = ingenieroResponsablePro;
		this.descripcionAvancePro = descripcionAvancePro;
		this.incidenciasPro = incidenciasPro;
	}

	public Integer getCodigoPro() {
		return codigoPro;
	}

	public void setCodigoPro(Integer codigoPro) {
		this.codigoPro = codigoPro;
	}

	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public String getLocalPro() {
		return localPro;
	}

	public void setLocalPro(String localPro) {
		this.localPro = localPro;
	}

	public String getIngenieroPro() {
		return ingenieroPro;
	}

	public void setIngenieroPro(String ingenieroPro) {
		this.ingenieroPro = ingenieroPro;
	}

	public Integer getCodigoAvancePro() {
		return codigoAvancePro;
	}

	public void setCodigoAvancePro(Integer codigoAvancePro) {
		this.codigoAvancePro = codigoAvancePro;
	}

	public Date getFechaAvancePro() {
		return fechaAvancePro;
	}

	public void setFechaAvancePro(Date fechaAvancePro) {
		this.fechaAvancePro = fechaAvancePro;
	}

	public String getIngenieroResponsablePro() {
		return ingenieroResponsablePro;
	}

	public void setIngenieroResponsablePro(String ingenieroResponsablePro) {
		this.ingenieroResponsablePro = ingenieroResponsablePro;
	}

	public String getDescripcionAvancePro() {
		return descripcionAvancePro;
	}

	public void setDescripcionAvancePro(String descripcionAvancePro) {
		this.descripcionAvancePro = descripcionAvancePro;
	}

	public String getIncidenciasPro() {
		return incidenciasPro;
	}

	public void setIncidenciasPro(String incidenciasPro) {
		this.incidenciasPro = incidenciasPro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}