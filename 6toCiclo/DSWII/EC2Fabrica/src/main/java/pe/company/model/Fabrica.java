package pe.company.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "fabrica")
public class Fabrica implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_fabrica")
    private Integer id;

    @Column(name = "nombre_fabrica", nullable = false)
    private String nombre;

    private String direccion;
    
    @Column(name = "telefono_contacto")
    private String telefonoContacto;

    @OneToMany(mappedBy = "fabrica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FabricaArticulo> fabricaArticulos;

    public Fabrica() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public List<FabricaArticulo> getFabricaArticulos() {
		return fabricaArticulos;
	}

	public void setFabricaArticulos(List<FabricaArticulo> fabricaArticulos) {
		this.fabricaArticulos = fabricaArticulos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}

