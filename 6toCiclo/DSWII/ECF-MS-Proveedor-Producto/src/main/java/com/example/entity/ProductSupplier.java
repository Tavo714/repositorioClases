package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_supplier")
public class ProductSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    // Constructor vacío
    public ProductSupplier() {}

    // Constructor completo
    public ProductSupplier(Long id, Long productId, Long supplierId) {
        this.id = id;
        this.productId = productId;
        this.supplierId = supplierId;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public Long getSupplierId() { return supplierId; }

    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
}
