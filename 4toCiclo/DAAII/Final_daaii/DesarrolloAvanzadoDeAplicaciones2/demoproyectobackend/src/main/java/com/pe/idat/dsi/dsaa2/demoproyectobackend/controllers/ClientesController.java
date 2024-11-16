package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    private ClientesService clientesService;

    public ClientesController(ClientesService clientesService){
        this.clientesService = clientesService;
    }

    

}
