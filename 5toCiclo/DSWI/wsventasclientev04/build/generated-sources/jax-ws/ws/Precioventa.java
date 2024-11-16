
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para precioventa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="precioventa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="preciocompra" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="margenutilidad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "precioventa", propOrder = {
    "preciocompra",
    "margenutilidad"
})
public class Precioventa {

    protected double preciocompra;
    protected double margenutilidad;

    /**
     * Obtiene el valor de la propiedad preciocompra.
     * 
     */
    public double getPreciocompra() {
        return preciocompra;
    }

    /**
     * Define el valor de la propiedad preciocompra.
     * 
     */
    public void setPreciocompra(double value) {
        this.preciocompra = value;
    }

    /**
     * Obtiene el valor de la propiedad margenutilidad.
     * 
     */
    public double getMargenutilidad() {
        return margenutilidad;
    }

    /**
     * Define el valor de la propiedad margenutilidad.
     * 
     */
    public void setMargenutilidad(double value) {
        this.margenutilidad = value;
    }

}
