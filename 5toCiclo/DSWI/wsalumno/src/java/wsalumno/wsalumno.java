/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsalumno;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ACER
 */
@WebService(serviceName = "wsalumno")
public class wsalumno {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "wscalcprom")
    public String wscalcprom(@WebParam(name = "nombre") String nombre, @WebParam(name = "carrera") String carrera, @WebParam(name = "turno") String turno, @WebParam(name = "practica") double practica, @WebParam(name = "participacion") double participacion, @WebParam(name = "examen") double examen) {
        if (turno.equals("mañana")){
            participacion +=1;
        }
        else if (turno.equals("tarde")){
            participacion +=3;
        }
        else if (turno.equals("noche")){
            participacion +=5;
        }
        
        double promedio= (practica+participacion+examen)/3;
        
        double notaMinima=0;
        
        if (carrera.equals("programacion")){
            notaMinima=14;
        } else if (carrera.equals("redes")){
            notaMinima=13;
        } else if (carrera.equals("web")){
            notaMinima=14.5;
        } else if (carrera.equals("office")){
            notaMinima=11;
        }
        
        String estado= (promedio >= notaMinima)? "APROBADO" : "DESAPROBADO";
        
        return estado;
    }
}
