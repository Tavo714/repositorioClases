
package wsalumno;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsalumno package. 
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

    private final static QName _WscalcpromResponse_QNAME = new QName("http://wsalumno/", "wscalcpromResponse");
    private final static QName _Wscalcprom_QNAME = new QName("http://wsalumno/", "wscalcprom");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsalumno
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Wscalcprom }
     * 
     */
    public Wscalcprom createWscalcprom() {
        return new Wscalcprom();
    }

    /**
     * Create an instance of {@link WscalcpromResponse }
     * 
     */
    public WscalcpromResponse createWscalcpromResponse() {
        return new WscalcpromResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WscalcpromResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsalumno/", name = "wscalcpromResponse")
    public JAXBElement<WscalcpromResponse> createWscalcpromResponse(WscalcpromResponse value) {
        return new JAXBElement<WscalcpromResponse>(_WscalcpromResponse_QNAME, WscalcpromResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Wscalcprom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsalumno/", name = "wscalcprom")
    public JAXBElement<Wscalcprom> createWscalcprom(Wscalcprom value) {
        return new JAXBElement<Wscalcprom>(_Wscalcprom_QNAME, Wscalcprom.class, null, value);
    }

}
