
package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "mascotaws", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8080/EC1Pregunta2/mascotaws?wsdl")
public class Mascotaws_Service
    extends Service
{

    private final static URL MASCOTAWS_WSDL_LOCATION;
    private final static WebServiceException MASCOTAWS_EXCEPTION;
    private final static QName MASCOTAWS_QNAME = new QName("http://ws/", "mascotaws");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/EC1Pregunta2/mascotaws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MASCOTAWS_WSDL_LOCATION = url;
        MASCOTAWS_EXCEPTION = e;
    }

    public Mascotaws_Service() {
        super(__getWsdlLocation(), MASCOTAWS_QNAME);
    }

    public Mascotaws_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MASCOTAWS_QNAME, features);
    }

    public Mascotaws_Service(URL wsdlLocation) {
        super(wsdlLocation, MASCOTAWS_QNAME);
    }

    public Mascotaws_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MASCOTAWS_QNAME, features);
    }

    public Mascotaws_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Mascotaws_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Mascotaws
     */
    @WebEndpoint(name = "mascotawsPort")
    public Mascotaws getMascotawsPort() {
        return super.getPort(new QName("http://ws/", "mascotawsPort"), Mascotaws.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Mascotaws
     */
    @WebEndpoint(name = "mascotawsPort")
    public Mascotaws getMascotawsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "mascotawsPort"), Mascotaws.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MASCOTAWS_EXCEPTION!= null) {
            throw MASCOTAWS_EXCEPTION;
        }
        return MASCOTAWS_WSDL_LOCATION;
    }

}