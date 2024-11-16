
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
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

    private final static QName _PrecioventaResponse_QNAME = new QName("http://ws/", "precioventaResponse");
    private final static QName _Precioventa_QNAME = new QName("http://ws/", "precioventa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrecioventaResponse }
     * 
     */
    public PrecioventaResponse createPrecioventaResponse() {
        return new PrecioventaResponse();
    }

    /**
     * Create an instance of {@link Precioventa }
     * 
     */
    public Precioventa createPrecioventa() {
        return new Precioventa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrecioventaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "precioventaResponse")
    public JAXBElement<PrecioventaResponse> createPrecioventaResponse(PrecioventaResponse value) {
        return new JAXBElement<PrecioventaResponse>(_PrecioventaResponse_QNAME, PrecioventaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Precioventa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "precioventa")
    public JAXBElement<Precioventa> createPrecioventa(Precioventa value) {
        return new JAXBElement<Precioventa>(_Precioventa_QNAME, Precioventa.class, null, value);
    }

}
