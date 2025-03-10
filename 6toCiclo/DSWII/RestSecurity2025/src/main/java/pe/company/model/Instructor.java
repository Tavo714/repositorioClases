package pe.company.model;

import java.io.Serializable;
import jakarta.persistence.*;
 
@Entity
@Table(name="instructores")
public class Instructor implements Serializable{
 
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer instructorId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private Double salario;
	
	public Instructor() {		
	}
 
	public Instructor(Integer instructorId, String nombre, String apellidos, Double salario) {
		this.instructorId = instructorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}
 
	public Integer getInstructorId() {
		return instructorId;
	}
 
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public String getApellidos() {
		return apellidos;
	}
 
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
 
	public Double getSalario() {
		return salario;
	}
 
	public void setSalario(Double salario) {
		this.salario = salario;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
