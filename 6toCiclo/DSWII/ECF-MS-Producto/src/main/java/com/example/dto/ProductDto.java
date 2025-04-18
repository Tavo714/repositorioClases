package com.example.dto;

public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String category;
    private Double unitPrice;
    private Boolean estado;

    private Integer stock;
    private Integer stockMinimo;

    public ProductDto() {}

    public ProductDto(Long id, String name, String description, String category, Double unitPrice, Boolean estado, Integer stock, Integer stockMinimo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.unitPrice = unitPrice;
        this.estado = estado;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    // Getters y Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public Double getUnitPrice() { return unitPrice; }

    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }

    public Boolean getEstado() { return estado; }

    public void setEstado(Boolean estado) { this.estado = estado; }

    public Integer getStock() { return stock; }

    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getStockMinimo() { return stockMinimo; }

    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }
}
