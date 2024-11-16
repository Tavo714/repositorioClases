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
import java.util.Date;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes cliente;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total")
    private double total;

    @Column(name = "estado")
    private String estado;

    public Pedidos(Long pedidoId, Clientes cliente, Date fecha, double total) {
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }

    public Pedidos updatePropierties(Pedidos model)
    {
        cliente = model.cliente;
        fecha = model.fecha;
        total = model.total;

        return this;

    }

    
}
