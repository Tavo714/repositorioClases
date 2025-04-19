package com.example.service;

import com.example.dto.CompraDto;
import com.example.dto.DetalleCompraDto;
import com.example.entity.Compra;
import com.example.entity.DetalleCompra;
import com.example.repository.CompraRepository;
import com.example.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private DetalleCompraRepository detalleRepository;

    @Override
    public void save(CompraDto dto) {
        double total = dto.getDetalles().stream()
                .mapToDouble(d -> d.getCantidad() * d.getPrecioUnitario())
                .sum();

        Compra compra = new Compra();
        compra.setFecha(dto.getFecha());
        compra.setProveedorId(dto.getProveedorId());
        compra.setTotal(total);

        compra = compraRepository.save(compra);

        for (DetalleCompraDto det : dto.getDetalles()) {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setCompra(compra);
            detalle.setProductoId(det.getProductoId());
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecioUnitario(det.getPrecioUnitario());
            detalle.setSubtotal(det.getCantidad() * det.getPrecioUnitario());
            detalleRepository.save(detalle);
        }
    }

    @Override
    public List<CompraDto> getAll() {
        return compraRepository.findAll().stream().map(c -> {
            List<DetalleCompraDto> detalles = c.getDetalles().stream().map(d -> new DetalleCompraDto(
                    d.getProductoId(), d.getCantidad(), d.getPrecioUnitario()
            )).collect(Collectors.toList());

            return new CompraDto(c.getProveedorId(), c.getFecha(), detalles);
        }).collect(Collectors.toList());
    }

    @Override
    public CompraDto getById(Long id) {
        Compra compra = compraRepository.findById(id).orElse(null);
        if (compra == null) return null;

        List<DetalleCompraDto> detalles = compra.getDetalles().stream().map(d -> new DetalleCompraDto(
                d.getProductoId(), d.getCantidad(), d.getPrecioUnitario()
        )).collect(Collectors.toList());

        return new CompraDto(compra.getProveedorId(), compra.getFecha(), detalles);
    }

    @Override
    public void update(Long id, CompraDto dto) {
        Compra compra = compraRepository.findById(id).orElse(null);
        if (compra == null) return;

        compra.setFecha(dto.getFecha());
        compra.setProveedorId(dto.getProveedorId());

        double total = dto.getDetalles().stream()
                .mapToDouble(d -> d.getCantidad() * d.getPrecioUnitario())
                .sum();
        compra.setTotal(total);

        compra = compraRepository.save(compra);

        detalleRepository.deleteAll(detalleRepository.findAll().stream()
                .filter(d -> d.getCompra().getId().equals(id))
                .toList());

        for (DetalleCompraDto det : dto.getDetalles()) {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setCompra(compra);
            detalle.setProductoId(det.getProductoId());
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecioUnitario(det.getPrecioUnitario());
            detalle.setSubtotal(det.getCantidad() * det.getPrecioUnitario());
            detalleRepository.save(detalle);
        }
    }

    @Override
    public void delete(Long id) {
        detalleRepository.deleteAll(detalleRepository.findAll().stream()
                .filter(d -> d.getCompra().getId().equals(id))
                .toList());
        compraRepository.deleteById(id);
    }
}
