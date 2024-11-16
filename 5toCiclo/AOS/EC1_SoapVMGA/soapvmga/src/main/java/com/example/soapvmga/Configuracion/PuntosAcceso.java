package com.example.soapvmga.Configuracion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soapvmga.Modelo.CEscuela;
import com.example.soapvmga.Servicio.ServicioEscuela;
import com.idat.sw.BuscarEscuelaRequest;
import com.idat.sw.BuscarEscuelaResponse;
import com.idat.sw.EliminarEscuelaRequest;
import com.idat.sw.EliminarEscuelaResponse;
import com.idat.sw.Escuela;
import com.idat.sw.Estado;
import com.idat.sw.GuardarEscuelaRequest;
import com.idat.sw.GuardarEscuelaResponse;
import com.idat.sw.ListarEscuelasRequest;
import com.idat.sw.ListarEscuelasResponse;

@Endpoint
public class PuntosAcceso {

    static final String url="http://idat.com/sw";

    @Autowired
    private ServicioEscuela se;

    @PayloadRoot(namespace=url, localPart = "BuscarEscuelaRequest")
    @ResponsePayload
    public BuscarEscuelaResponse BuscarEscuela(@RequestPayload BuscarEscuelaRequest peticion){
        BuscarEscuelaResponse ob=new BuscarEscuelaResponse();
        CEscuela cescuela=se.BuscarEscuela(peticion.getCodigo());
        Escuela eescuela= new Escuela();
        BeanUtils.copyProperties(cescuela, eescuela);
        ob.setEscuela(eescuela);
        return ob;
    }

    @PayloadRoot(namespace=url, localPart = "GuardarEscuelaRequest")
    @ResponsePayload
    public GuardarEscuelaResponse GuardarEscuela(@RequestPayload GuardarEscuelaRequest peticion){
        GuardarEscuelaResponse ob=new GuardarEscuelaResponse();
        Estado estado = new Estado();
        Escuela eescuela= new Escuela();
        CEscuela cescuela= new CEscuela(peticion.getCodesc(),
                                        peticion.getDesesc(),
                                        peticion.getCodfac(),
                                        peticion.getUbiesc());
    
        CEscuela e=se.GuardarEscuela(cescuela);
        if (e==null){
            estado.setCodigo("ERROR");
            estado.setMensaje("Error al registrar datos de la escuela...!");
        }
        else{
            estado.setCodigo("EXITO");
            estado.setMensaje("Se registraro correctamente los datos de la escuela...!");
        }
        BeanUtils.copyProperties(e, eescuela);
        ob.setEscuela(eescuela);
        ob.setEstado(estado);
        return ob;
    }

    @PayloadRoot(namespace = url, localPart = "ListarEscuelasRequest")
    @ResponsePayload
    public ListarEscuelasResponse ListarEscuelas(@RequestPayload ListarEscuelasRequest peticion){
        ListarEscuelasResponse ob=new ListarEscuelasResponse();
        List<CEscuela> listae= se.ListarEscuelas();
        List<Escuela> elista=new ArrayList<Escuela>();
        for(CEscuela reg:listae){
            Escuela eescuela=new Escuela();
            BeanUtils.copyProperties(reg, eescuela);
            elista.add(eescuela);
        }
        ob.getEscuela().addAll(elista);
        return ob;
    }

    @PayloadRoot(namespace = url, localPart = "EliminarEscuelaRequest")
    @ResponsePayload
    public EliminarEscuelaResponse EliminarEscuela(@RequestPayload EliminarEscuelaRequest peticion){
        EliminarEscuelaResponse ob=new EliminarEscuelaResponse();
        Estado estado = new Estado();
        boolean re=se.EliminarEscuela(peticion.getCodfac());
        if(re){
            estado.setCodigo("EXITO");
            estado.setMensaje("Elimino correctamente el registro de la escuela...!");
        }
        else{
            estado.setCodigo("ERROR");
            estado.setMensaje("Imposible Eliminar el registro de la escuela...!");
        }
        ob.setEstado(estado);
        return ob;
    }

}
