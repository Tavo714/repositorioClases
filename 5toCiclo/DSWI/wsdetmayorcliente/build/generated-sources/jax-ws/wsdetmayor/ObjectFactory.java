
package wsdetmayor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdetmayor package. 
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

    private final static QName _Detmayor_QNAME = new QName("http://wsdetmayor/", "detmayor");
    private final static QName _DetmayorResponse_QNAME = new QName("http://wsdetmayor/", "detmayorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdetmayor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DetmayorResponse }
     * 
     */
    public DetmayorResponse createDetmayorResponse() {
        return new DetmayorResponse();
    }

    /**
     * Create an instance of {@link Detmayor }
     * 
     */
    public Detmayor createDetmayor() {
        return new Detmayor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Detmayor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdetmayor/", name = "detmayor")
    public JAXBElement<Detmayor> createDetmayor(Detmayor value) {
        return new JAXBElement<Detmayor>(_Detmayor_QNAME, Detmayor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetmayorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdetmayor/", name = "detmayorResponse")
    public JAXBElement<DetmayorResponse> createDetmayorResponse(DetmayorResponse value) {
        return new JAXBElement<DetmayorResponse>(_DetmayorResponse_QNAME, DetmayorResponse.class, null, value);
    }

}
