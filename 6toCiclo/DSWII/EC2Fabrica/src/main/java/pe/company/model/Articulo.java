package pe.company.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_articulo")
    private Integer id;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoArticulo> pedidoArticulos;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FabricaArticulo> fabricaArticulos;

    public Articulo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PedidoArticulo> getPedidoArticulos() {
		return pedidoArticulos;
	}

	public void setPedidoArticulos(List<PedidoArticulo> pedidoArticulos) {
		this.pedidoArticulos = pedidoArticulos;
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

