
package wsproducto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsproducto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WscalcprecioResponse_QNAME = new QName("http://wsproducto/", "wscalcprecioResponse");
    private final static QName _Wscalcprecio_QNAME = new QName("http://wsproducto/", "wscalcprecio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsproducto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Wscalcprecio }
     * 
     */
    public Wscalcprecio createWscalcprecio() {
        return new Wscalcprecio();
    }

    /**
     * Create an instance of {@link WscalcprecioResponse }
     * 
     */
    public WscalcprecioResponse createWscalcprecioResponse() {
        return new WscalcprecioResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WscalcprecioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsproducto/", name = "wscalcprecioResponse")
    public JAXBElement<WscalcprecioResponse> createWscalcprecioResponse(WscalcprecioResponse value) {
        return new JAXBElement<WscalcprecioResponse>(_WscalcprecioResponse_QNAME, WscalcprecioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Wscalcprecio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsproducto/", name = "wscalcprecio")
    public JAXBElement<Wscalcprecio> createWscalcprecio(Wscalcprecio value) {
        return new JAXBElement<Wscalcprecio>(_Wscalcprecio_QNAME, Wscalcprecio.class, null, value);
    }

}
