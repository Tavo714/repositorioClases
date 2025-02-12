package pe.negocio.model;

import java.io.Serializable;
import java.util.Date;
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
	private String password;	
	@Column(unique=true,nullable=false)
	private String email;
	@Temporal(TemporalType.DATE)
	private Date fregistro;
	
	public Instructor() {		
	}
	
	public Instructor(Instructor instructor) {
		this(instructor.getInstructorId(),
			 instructor.getNombre(),
			 instructor.getApellidos(),
			 instructor.getPassword(),
			 instructor.getEmail(),
			 instructor.getFregistro());
	}

	public Instructor(Integer instructorId, String nombre, String apellidos, String password, String email,
			Date fregistro) {
				this.instructorId = instructorId;
				this.nombre = nombre;
				this.apellidos = apellidos;
				this.password = password;
				this.email = email;
				this.fregistro = fregistro;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
