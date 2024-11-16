
package wsdetmayor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para detmayor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detmayor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="c" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="d" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mayor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detmayor", propOrder = {
    "a",
    "b",
    "c",
    "d",
    "mayor"
})
public class Detmayor {

    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int mayor;

    /**
     * Obtiene el valor de la propiedad a.
     * 
     */
    public int getA() {
        return a;
    }

    /**
     * Define el valor de la propiedad a.
     * 
     */
    public void setA(int value) {
        this.a = value;
    }

    /**
     * Obtiene el valor de la propiedad b.
     * 
     */
    public int getB() {
        return b;
    }

    /**
     * Define el valor de la propiedad b.
     * 
     */
    public void setB(int value) {
        this.b = value;
    }

    /**
     * Obtiene el valor de la propiedad c.
     * 
     */
    public int getC() {
        return c;
    }

    /**
     * Define el valor de la propiedad c.
     * 
     */
    public void setC(int value) {
        this.c = value;
    }

    /**
     * Obtiene el valor de la propiedad d.
     * 
     */
    public int getD() {
        return d;
    }

    /**
     * Define el valor de la propiedad d.
     * 
     */
    public void setD(int value) {
        this.d = value;
    }

    /**
     * Obtiene el valor de la propiedad mayor.
     * 
     */
    public int getMayor() {
        return mayor;
    }

    /**
     * Define el valor de la propiedad mayor.
     * 
     */
    public void setMayor(int value) {
        this.mayor = value;
    }

}
