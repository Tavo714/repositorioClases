
package wscalcular;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wscalcular package. 
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

    private final static QName _CalcularResponse_QNAME = new QName("http://wscalcular/", "calcularResponse");
    private final static QName _Calcular_QNAME = new QName("http://wscalcular/", "calcular");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wscalcular
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Calcular }
     * 
     */
    public Calcular createCalcular() {
        return new Calcular();
    }

    /**
     * Create an instance of {@link CalcularResponse }
     * 
     */
    public CalcularResponse createCalcularResponse() {
        return new CalcularResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcularResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscalcular/", name = "calcularResponse")
    public JAXBElement<CalcularResponse> createCalcularResponse(CalcularResponse value) {
        return new JAXBElement<CalcularResponse>(_CalcularResponse_QNAME, CalcularResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Calcular }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscalcular/", name = "calcular")
    public JAXBElement<Calcular> createCalcular(Calcular value) {
        return new JAXBElement<Calcular>(_Calcular_QNAME, Calcular.class, null, value);
    }

}
