package pe.escuela.model;

import java.io.Serializable;
import jakarta.persistence.*;
 
@Entity
@Table(name="taller")
public class Taller implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tallerId;
	
	@Column
	private String nombre;
	
	@Column
	private double costo;
	
	@OneToOne
	@JoinColumn(name="instructor_id",nullable=false,foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(instructor_id) references instructores(instructor_id)"))
	private Instructor instructor;
	
	public Taller() {
		
	}
	
	public Taller(Taller taller)
	{
		this(taller.getTallerId(), taller.getNombre(), taller.getCosto());		
	}
 
	public Taller(Integer tallerId, String nombre, double costo) {
		this.tallerId = tallerId;
		this.nombre = nombre;
		this.costo = costo;
		}
 
	public Integer getTallerId() {
		return tallerId;
	}
 
	public void setTallerId(Integer tallerId) {
		this.tallerId = tallerId;
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public double getCosto() {
		return costo;
	}
 
	public void setCosto(double costo) {
		this.costo = costo;
	}
 
	public Instructor getInstructor() {
		return instructor;
	}
 
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
}
