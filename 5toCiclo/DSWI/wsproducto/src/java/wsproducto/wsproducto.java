/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsproducto;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ACER
 */
@WebService(serviceName = "wsproducto")
public class wsproducto {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "wscalcprecio")
    public String wscalcprecio(@WebParam(name = "articulo") String articulo, @WebParam(name = "precioCompra") double precioCompra, @WebParam(name = "linea") String linea, @WebParam(name = "servAdicional") String servAdicional) {
        double incremento = 0.0;
        
        switch(linea){
            case "abarrotes":
            incremento=0.15;
            break;
            
            case "ferreteria":
                incremento=0.18;
                break;
                
            case "licores":
                incremento=0.2;
                break;
                
            case "perfumes":
                incremento=0.22;
                break;
                
            case "artefactos":
                incremento=0.25;
                break;                           
        }
        
        double precioVenta=precioCompra+(precioCompra*incremento);
        
        if(servAdicional !=null){
            if(servAdicional.equals("flete")){
                precioVenta+=5;
            }else if (servAdicional.equals("Mantenimiento")){
                precioVenta+=7;
            }else if (servAdicional.equals("Seguro")){
                precioVenta+=5;
            }
        }
        
        double igv=precioVenta*0.18;
        
        double total = precioVenta+igv;
        
        return String.format("%2f",total);
    }
}
