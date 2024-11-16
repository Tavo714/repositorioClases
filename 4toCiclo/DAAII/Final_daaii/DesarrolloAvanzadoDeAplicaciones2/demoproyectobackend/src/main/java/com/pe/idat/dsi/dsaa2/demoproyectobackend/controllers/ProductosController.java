package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ProductosService;


@Controller
@RequestMapping("/productos")
public class ProductosController {

    private ProductosService productosService;

    public ProductosController(ProductosService productosService){
        this.productosService = productosService;
    }

}
