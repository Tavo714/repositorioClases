package com.example.aplicacionsoap.Configuracion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.comercio.sw.BuscarProductoRequest;
import com.comercio.sw.BuscarProductoResponse;
import com.comercio.sw.EliminarProductoRequest;
import com.comercio.sw.EliminarProductoResponse;
import com.comercio.sw.Estado;
import com.comercio.sw.GuardarProductoRequest;
import com.comercio.sw.GuardarProductoResponse;
import com.comercio.sw.ListarProductosRequest;
import com.comercio.sw.ListarProductosResponse;
import com.comercio.sw.Producto;
import com.example.aplicacionsoap.Modelo.CProducto;
import com.example.aplicacionsoap.Servicio.ServicioProducto;

@Endpoint
public class PuntosAcceso {

    static final String url="http://comercio.com/sw";

    @Autowired
    private ServicioProducto sp;

    @PayloadRoot(namespace = url, localPart = "BuscarProductoRequest")
    @ResponsePayload
    public BuscarProductoResponse BuscarProducto(@RequestPayload BuscarProductoRequest peticion){
        BuscarProductoResponse ob=new BuscarProductoResponse();
        CProducto cproducto= sp.BuscarProducto(peticion.getCodigo());
        Producto eproducto= new Producto();
        BeanUtils.copyProperties(cproducto, eproducto);
        ob.setProducto(eproducto);
        return ob;
    }

    @PayloadRoot(namespace = url, localPart = "GuardarProductoRequest")
    @ResponsePayload
    public GuardarProductoResponse GuardarProducto(@RequestPayload GuardarProductoRequest peticion){
        GuardarProductoResponse ob=new GuardarProductoResponse();
        Estado estado = new Estado();
        Producto eproducto = new Producto();
        CProducto cproducto= new CProducto(peticion.getCodpro(), 
                                           peticion.getCodcat(), 
                                           peticion.getDespro(), 
                                           peticion.getUnipro(), 
                                           peticion.getPcopro(),
                                           peticion.getPvepro(),
                                           peticion.getStopro(),
                                           peticion.getFrepro());
        CProducto p=sp.GuardarProducto(cproducto);
        if (p==null){
            estado.setCodigo("ERROR");
            estado.setMensaje("Error al registrar datos del producto...!");
        }
        else{
            estado.setCodigo("EXITO");
            estado.setMensaje("Se registraron correctamente los datos del producto...!");
        }
        BeanUtils.copyProperties(p, eproducto);
        ob.setProducto(eproducto);
        ob.setEstado(estado);
        return ob;
    }

    @PayloadRoot(namespace = url, localPart = "ListarProductosRequest")
    @ResponsePayload
    public ListarProductosResponse ListarProductos(@RequestPayload ListarProductosRequest peticion){
        ListarProductosResponse ob=new ListarProductosResponse();
        List<CProducto> listap= sp.ListarProductos();
        List<Producto> elista= new ArrayList<Producto>();
        for(CProducto reg:listap){
            Producto eproducto=new Producto();
            BeanUtils.copyProperties(reg, eproducto);
            elista.add(eproducto);
        }
        ob.getProducto().addAll(elista);
        return ob;
    }

    @PayloadRoot(namespace = url, localPart = "EliminarProductoRequest")
    @ResponsePayload
    public EliminarProductoResponse EliminarProducto(@RequestPayload EliminarProductoRequest peticion){
        EliminarProductoResponse ob=new EliminarProductoResponse();
        Estado estado = new Estado();
        boolean re=sp.EliminarProducto(peticion.getCodpro());
        if (re){
            estado.setCodigo("EXITO");
            estado.setMensaje("Elimino correctamente el registro del producto...!");
        }
        else{
            estado.setCodigo("ERROR");
            estado.setMensaje("Imposible Eliminar el registro del producto...!");
        }
        ob.setEstado(estado);
        return ob;
    }

}
