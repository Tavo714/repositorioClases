/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ACER
 */
@WebService(serviceName = "wsventas")
public class wsventas {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "precioventa")
    public Double precioventa(@WebParam(name = "preciocompra") double preciocompra, @WebParam(name = "margenutilidad") double margenutilidad) {
        double pv = 0.0;
        double igv = 0.0;
        
        igv = (preciocompra + margenutilidad)*0.18;
        pv = preciocompra+margenutilidad+igv;
        
        return pv;
    }
}
