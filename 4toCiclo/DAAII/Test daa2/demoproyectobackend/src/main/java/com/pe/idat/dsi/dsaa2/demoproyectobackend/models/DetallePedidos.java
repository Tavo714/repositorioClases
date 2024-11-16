package com.pe.idat.dsi.dsaa2.demoproyectobackend.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleId;
  
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedidos pedido;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "estado")
    private String estado;

    public DetallePedidos(Long detalleId, Pedidos pedido, Productos producto, int cantidad, double precioUnitario) {
        this.detalleId = detalleId;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetallePedidos updatePropierties(DetallePedidos model)
    {
        pedido = model.pedido;
        producto = model.producto;
        cantidad = model.cantidad;
        precioUnitario = model.precioUnitario;
        return this;

    }

    
    

    
}
