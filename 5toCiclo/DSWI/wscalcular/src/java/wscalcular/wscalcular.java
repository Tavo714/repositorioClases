/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscalcular;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ACER
 */
@WebService(serviceName = "wscalcular")
public class wscalcular {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "calcular")
    public Double calcular(@WebParam(name = "r") double r, @WebParam(name = "x") double x, @WebParam(name = "a") double a, @WebParam(name = "b") double b, @WebParam(name = "c") double c, @WebParam(name = "t") double t) {
        r=((4*x)*(a/2))+((b-c)*(Math.cbrt(t)));
        return r;
    }
}
