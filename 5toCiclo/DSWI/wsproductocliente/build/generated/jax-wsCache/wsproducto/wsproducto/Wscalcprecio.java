
package wsproducto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wscalcprecio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wscalcprecio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="articulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precioCompra" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="linea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servAdicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wscalcprecio", propOrder = {
    "articulo",
    "precioCompra",
    "linea",
    "servAdicional"
})
public class Wscalcprecio {

    protected String articulo;
    protected double precioCompra;
    protected String linea;
    protected String servAdicional;

    /**
     * Obtiene el valor de la propiedad articulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticulo() {
        return articulo;
    }

    /**
     * Define el valor de la propiedad articulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticulo(String value) {
        this.articulo = value;
    }

    /**
     * Obtiene el valor de la propiedad precioCompra.
     * 
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * Define el valor de la propiedad precioCompra.
     * 
     */
    public void setPrecioCompra(double value) {
        this.precioCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad linea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Define el valor de la propiedad linea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinea(String value) {
        this.linea = value;
    }

    /**
     * Obtiene el valor de la propiedad servAdicional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServAdicional() {
        return servAdicional;
    }

    /**
     * Define el valor de la propiedad servAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServAdicional(String value) {
        this.servAdicional = value;
    }

}
