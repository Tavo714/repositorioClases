package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SecuredController {

    @PostMapping("/calcular-precio")
    public Map<String, Object> calcularPrecio(@RequestParam String nombreProducto,
                                              @RequestParam double precioCompra) {

        double margenUtilidad;
        if (precioCompra >= 50 && precioCompra <= 100) {
            margenUtilidad = precioCompra * 0.25;
        } else {
            margenUtilidad = precioCompra * 0.30;
        }

        double flete = (precioCompra > 20) ? 5.0 : 1.5;

        double baseImponible = precioCompra + margenUtilidad + flete;
        double igv = baseImponible * 0.18;

        double precioVenta = baseImponible + igv;

        Map<String, Object> response = new HashMap<>();
        response.put("producto", nombreProducto);
        response.put("precio_venta", Math.round(precioVenta * 100.0) / 100.0); // Redondeo a 2 decimales

        return response;
    }
}
