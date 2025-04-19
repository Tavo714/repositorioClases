package com.example.dto;

public class ProductSupplierDto {

    private Long id;
    private Long productId;
    private Long supplierId;

    public ProductSupplierDto() {}

    public ProductSupplierDto(Long id, Long productId, Long supplierId) {
        this.id = id;
        this.productId = productId;
        this.supplierId = supplierId;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
