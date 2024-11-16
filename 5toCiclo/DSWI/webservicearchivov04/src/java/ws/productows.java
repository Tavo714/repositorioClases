package ws;
 
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Collection;
import javax.jws.*;
import dao.productodao;
import vo.productovo;
 
@WebService(serviceName = "productows")
public class productows {
    //se instancia dao del producto
    private productodao productodao=new productodao(); 

    @WebMethod(operationName = "listarproductos")
    public Collection<productovo> listarproductos(@WebParam(name = "codigo") String codigo) {
        return productodao.findAll();
    }
}

 