package pe.company.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido_articulo")
public class PedidoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "num_pedido", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_pedido_articulo_pedido"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "num_articulo", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_pedido_articulo_articulo"))
    private Articulo articulo;

    @Column(nullable = false)
    private Integer cantidad;

    public PedidoArticulo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
