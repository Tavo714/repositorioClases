package com.example.dto;

import java.time.LocalDate;
import java.util.List;

public class CompraDto {

    private Long proveedorId;
    private LocalDate fecha;
    private List<DetalleCompraDto> detalles;

    public CompraDto() {}

    public CompraDto(Long proveedorId, LocalDate fecha, List<DetalleCompraDto> detalles) {
        this.proveedorId = proveedorId;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<DetalleCompraDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompraDto> detalles) {
        this.detalles = detalles;
    }
}
