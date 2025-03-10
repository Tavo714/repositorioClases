package pe.company.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "fabrica_articulo")
public class FabricaArticulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "num_fabrica", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_fabrica_articulo_fabrica"))
    private Fabrica fabrica;

    @ManyToOne
    @JoinColumn(name = "num_articulo", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_fabrica_articulo_articulo"))
    private Articulo articulo;

    @Column(nullable = false)
    private Integer existencias;

    public FabricaArticulo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
