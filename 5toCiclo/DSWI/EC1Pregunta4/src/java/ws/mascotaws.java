
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Collection;
import javax.jws.*;
import dao.mascotadao;
import vo.mascotavo;

@WebService(serviceName = "mascotaws")
public class mascotaws {
    
    private mascotadao mascotadao=new mascotadao(); 

    @WebMethod(operationName = "listarmascotas")
    public Collection<mascotavo> listarmascotas(@WebParam(name = "codigo") String codigo) {
        return mascotadao.findAll();
    }
}
