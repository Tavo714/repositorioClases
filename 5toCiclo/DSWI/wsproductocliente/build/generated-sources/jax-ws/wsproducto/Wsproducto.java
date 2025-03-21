
package wsproducto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "wsproducto", targetNamespace = "http://wsproducto/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Wsproducto {


    /**
     * 
     * @param servAdicional
     * @param precioCompra
     * @param articulo
     * @param linea
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "wscalcprecio", targetNamespace = "http://wsproducto/", className = "wsproducto.Wscalcprecio")
    @ResponseWrapper(localName = "wscalcprecioResponse", targetNamespace = "http://wsproducto/", className = "wsproducto.WscalcprecioResponse")
    @Action(input = "http://wsproducto/wsproducto/wscalcprecioRequest", output = "http://wsproducto/wsproducto/wscalcprecioResponse")
    public String wscalcprecio(
        @WebParam(name = "articulo", targetNamespace = "")
        String articulo,
        @WebParam(name = "precioCompra", targetNamespace = "")
        double precioCompra,
        @WebParam(name = "linea", targetNamespace = "")
        String linea,
        @WebParam(name = "servAdicional", targetNamespace = "")
        String servAdicional);

}
