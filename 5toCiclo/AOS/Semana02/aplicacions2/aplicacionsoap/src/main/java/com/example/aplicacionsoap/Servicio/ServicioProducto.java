package com.example.aplicacionsoap.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplicacionsoap.Interfaz.IProducto;
import com.example.aplicacionsoap.Modelo.CProducto;

@Service
public class ServicioProducto {

    @Autowired
    private IProducto ipro;

    public List<CProducto> ListarProductos(){
        return (List<CProducto>) ipro.findAll();
    }

    public CProducto BuscarProducto(long codigo){
        return ipro.findById(codigo).get();
    }

    public CProducto GuardarProducto(CProducto p){
        return ipro.save(p);
    }

    public boolean EliminarProducto(Long codigo){
        boolean sw=false;
        try{
            sw=ipro.findById(codigo).isPresent();
            if(sw) ipro.deleteById(codigo);
        }
        catch(Exception e){
            sw=false;
        }
        return sw;
    }

}
