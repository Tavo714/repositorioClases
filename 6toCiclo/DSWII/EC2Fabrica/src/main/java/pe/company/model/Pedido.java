package pe.company.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_pedido")
    private Integer id;

    @Column(name = "direccion_envio", nullable = false)
    private String direccionEnvio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;

    @ManyToOne
    @JoinColumn(name = "num_cliente", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_pedido_cliente"))
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoArticulo> pedidoArticulos;

    @PrePersist
    public void prePersist() {
        fechaPedido = new Date();
    }

    public Pedido() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoArticulo> getPedidoArticulos() {
		return pedidoArticulos;
	}

	public void setPedidoArticulos(List<PedidoArticulo> pedidoArticulos) {
		this.pedidoArticulos = pedidoArticulos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}

