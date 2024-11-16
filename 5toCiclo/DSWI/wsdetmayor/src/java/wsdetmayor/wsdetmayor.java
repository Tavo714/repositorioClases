/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsdetmayor;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ACER
 */
@WebService(serviceName = "wsdetmayor")
public class wsdetmayor {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "detmayor")
    public Integer detmayor(@WebParam(name = "a") int a, @WebParam(name = "b") int b, @WebParam(name = "c") int c, @WebParam(name = "d") int d, @WebParam(name = "mayor") int mayor) {        
        
        mayor=a;
        
        if (a>b && a>c && a>d){
            mayor = a;
        }
        
        if (b>a && b>c && b>d){
            mayor=b;
        }
        
        if (c>a && c>b && c>d){
            mayor=c;
        }
        
        if (d>a && d>b && d>c){
            mayor=d;
        }
        
        return mayor;
    }
}
