
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

    private final static QName _Lista_QNAME = new QName("http://ws/", "lista");
    private final static QName _ListaResponse_QNAME = new QName("http://ws/", "listaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Lista }
     * 
     */
    public Lista createLista() {
        return new Lista();
    }

    /**
     * Create an instance of {@link ListaResponse }
     * 
     */
    public ListaResponse createListaResponse() {
        return new ListaResponse();
    }

    /**
     * Create an instance of {@link Mascota }
     * 
     */
    public Mascota createMascota() {
        return new Mascota();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lista }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "lista")
    public JAXBElement<Lista> createLista(Lista value) {
        return new JAXBElement<Lista>(_Lista_QNAME, Lista.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "listaResponse")
    public JAXBElement<ListaResponse> createListaResponse(ListaResponse value) {
        return new JAXBElement<ListaResponse>(_ListaResponse_QNAME, ListaResponse.class, null, value);
    }

}
