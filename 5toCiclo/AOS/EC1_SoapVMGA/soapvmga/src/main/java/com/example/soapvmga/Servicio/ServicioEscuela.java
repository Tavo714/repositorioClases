package com.example.soapvmga.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soapvmga.Interfaz.IEscuela;
import com.example.soapvmga.Modelo.CEscuela;

@Service
public class ServicioEscuela {

    @Autowired
    private IEscuela iesc;

    public List<CEscuela> ListarEscuelas(){
        return (List<CEscuela>) iesc.findAll();
    }

    public CEscuela BuscarEscuela(int codigo){
        return iesc.findById(codigo).get();
    }

    public CEscuela GuardarEscuela(CEscuela e){
        return iesc.save(e);
    }

    public boolean EliminarEscuela(int codigo){
        boolean sw=false;
        try{
            sw=iesc.findById(codigo).isPresent();
            if(sw) iesc.deleteById(codigo);
        }
        catch(Exception e){
            sw=false;
        }
        return sw;
    }

}
