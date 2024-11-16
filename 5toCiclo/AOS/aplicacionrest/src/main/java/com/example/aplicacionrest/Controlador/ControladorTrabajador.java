package com.example.aplicacionrest.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aplicacionrest.Modelo.CTrabajador;
import com.example.aplicacionrest.Servicio.ServicioTrabajador;

@RestController
@RequestMapping("/Trabajador")
public class ControladorTrabajador {

    @Autowired
    ServicioTrabajador st;

    @GetMapping
    public List<CTrabajador> ListarTrabajadores(){
        return st.ListarTrabajadores();
    }

    @GetMapping("/dni/{dnitra}")
    public CTrabajador BuscarDni(@PathVariable String dnitra){
        return st.BuscarDni(dnitra);
    }

    @GetMapping("/telefono/{fono}")
    public CTrabajador BuscarTelefono(@PathVariable String fono){
        return st.BuscarTelefono(fono);
    }

    @PostMapping
    public CTrabajador GuardarTrabajador(@RequestBody CTrabajador t){
        return st.GuardarTrabajador(t);
    }

    @DeleteMapping("/{dni}")
    public String EliminarTrabajador(@PathVariable String dni){
        if(st.EliminarTrabajador(dni)){
            return "Elimino correctamente el registro del Trabajador...!";
        }
        else{
            return "Imposible eliminar el registro del Trabajador...!";
        }
    }

    @PutMapping
    public CTrabajador ActualizarTrabajador(@RequestBody CTrabajador t){
        return st.ActualizarTrabajador(t);
    }

}
