/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsservicearrayclientev04;

import java.util.Collection;
import ws.Empleado;

public class Wsservicearrayclientev04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Collection<Empleado> itemsempleado = lista("101");
        
        for(Empleado item:itemsempleado){
            System.out.println("Id Empelado: "+ item.getIdEmpleado());
            System.out.println("Nombre: "+ item.getNombre());
            System.out.println("Fecha de Contrato: "+ item.getFechaContrato());
            System.out.println("Cargo Laboral: "+ item.getProfesion());
            System.out.println("Sueldo S/ "+ item.getSueldo());
            System.out.println("\n");
        }
    }

    private static java.util.List<ws.Empleado> lista(java.lang.String codigo) {
        ws.Wsempleadoarray_Service service = new ws.Wsempleadoarray_Service();
        ws.Wsempleadoarray port = service.getWsempleadoarrayPort();
        return port.lista(codigo);
    }
    
}
