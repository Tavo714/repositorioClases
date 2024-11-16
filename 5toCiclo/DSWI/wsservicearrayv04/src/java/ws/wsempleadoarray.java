/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.*; // nuevo agregado
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.empleado; // nuevo agregado


@WebService(serviceName = "wsempleadoarray")
public class wsempleadoarray {

    private static final Collection<empleado> itemsempleado = new ArrayList();
    static {
        empleado empleado1 = new empleado(101, "Teresa", new GregorianCalendar(2024,03,10).getTime(), "Contadora", 2600.00);
        empleado empleado2 = new empleado(102, "Fernando", new GregorianCalendar(2023,04,26).getTime(), "Vendedor", 2200.00);
        empleado empleado3 = new empleado(103, "Alicia", new GregorianCalendar(2022,11,8).getTime(), "Cajera", 2200.00);
        empleado empleado4 = new empleado(104, "Juliana", new GregorianCalendar(2024,04,14).getTime(), "Marketing", 2500.00);
        
        itemsempleado.add(empleado1);
        itemsempleado.add(empleado2);
        itemsempleado.add(empleado3);
        itemsempleado.add(empleado4);
    }
    
    @WebMethod(operationName = "lista")
    public Collection<empleado> listaempleado(@WebParam(name = "codigo") String codigo) {
        return itemsempleado;
    }
}
