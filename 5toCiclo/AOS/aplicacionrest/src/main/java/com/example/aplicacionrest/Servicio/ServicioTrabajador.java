package com.example.aplicacionrest.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplicacionrest.Interfaz.ITrabajador;
import com.example.aplicacionrest.Modelo.CTrabajador;

@Service
public class ServicioTrabajador {

    @Autowired
    private ITrabajador itra;

    public List<CTrabajador> ListarTrabajadores(){
        return (List<CTrabajador>) itra.findAll();
    }

    public CTrabajador BuscarDni(String dni){
        Optional<CTrabajador> reg=itra.findBydnitra(dni);
        if (reg.isPresent()){
            return reg.get();
        }
        else{
            return null;
        }
    }

    public CTrabajador BuscarTelefono(String telefono){
        Optional<CTrabajador> reg=itra.findByteltra(telefono);
        if (reg.isPresent()){
            return reg.get();
        }
        else{
            return null;
        }
    }

    public CTrabajador BuscarCodigo(Integer codigo){
        return itra.findById(codigo).get();
    }

    public CTrabajador GuardarTrabajador(CTrabajador t){
        Optional<CTrabajador> reg=itra.findBydnitra(t.getDnitra());
        if(!reg.isPresent()){
            return itra.save(t);
        }
        else{
            return null;
        }
    }

    public boolean EliminarTrabajador(String dni){
        Optional<CTrabajador> reg=itra.findBydnitra(dni);
        if (reg.isPresent()){
            itra.deleteById(reg.get().getCodtra());
            return true;
        }
        else{
            return false;
        }
    }

    public CTrabajador ActualizarTrabajador(CTrabajador t){
        Optional<CTrabajador> reg=itra.findById(t.getCodtra());
        if(reg.isPresent()){
            //------Atualizar Datos del Trabajador
            CTrabajador regan=reg.get();
            if(t.getApetra()==null)t.setApetra(regan.getApetra());
            if(t.getNomtra()==null)t.setNomtra(regan.getNomtra());
            if(t.getDnitra()==null)t.setDnitra(regan.getDnitra());
            if(t.getDirtra()==null)t.setDirtra(regan.getDirtra());
            if(t.getTeltra()==null)t.setTeltra(regan.getTeltra());
            if(t.getCortra()==null)t.setCortra(regan.getCortra());
            if(t.getFretra()==null)t.setFretra(regan.getFretra());
            return itra.save(t);
        }
        else{
            return null;
        }
    }

}
