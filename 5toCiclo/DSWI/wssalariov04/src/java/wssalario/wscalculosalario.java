/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wssalario;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ACER
 */
@WebService(serviceName = "wscalculosalario")
public class wscalculosalario {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salarioobrero")
    public String salarioobrero(@WebParam(name = "preciohora") double preciohora, @WebParam(name = "horastrabajadas") double horastrabajadas) {
        double salario = 0.0;
        salario = preciohora * horastrabajadas;
        return "El salario del obrero es igual = " +String.valueOf(salario) + ", Constructora ASALDE SAC";
    }
}
