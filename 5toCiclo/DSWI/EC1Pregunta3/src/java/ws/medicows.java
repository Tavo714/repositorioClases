
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Collection;
import javax.jws.*;
import dao.medicodao;
import vo.medicovo;

@WebService(serviceName = "medicows")
public class medicows {
    
    private medicodao medicodao=new medicodao(); 

    @WebMethod(operationName = "lsitarmedicos")
    public Collection<medicovo> listarmedicos(@WebParam(name = "codigo") String codigo) {
        return medicodao.findAll();
    }
}
