package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @Column(name = "proveedor_id")
    private Long proveedorId;

    private Double total;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleCompra> detalles;

    // Constructores
    public Compra() {}

    public Compra(Long id, LocalDate fecha, Long proveedorId, Double total) {
        this.id = id;
        this.fecha = fecha;
        this.proveedorId = proveedorId;
        this.total = total;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public List<DetalleCompra> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
        if (detalles != null) {
            for (DetalleCompra d : detalles) {
                d.setCompra(this);
            }
        }
    }
}
