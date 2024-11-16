
package wscalcular;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para calcular complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="calcular">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="r" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="c" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calcular", propOrder = {
    "r",
    "x",
    "a",
    "b",
    "c",
    "t"
})
public class Calcular {

    protected double r;
    protected double x;
    protected double a;
    protected double b;
    protected double c;
    protected double t;

    /**
     * Obtiene el valor de la propiedad r.
     * 
     */
    public double getR() {
        return r;
    }

    /**
     * Define el valor de la propiedad r.
     * 
     */
    public void setR(double value) {
        this.r = value;
    }

    /**
     * Obtiene el valor de la propiedad x.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * Define el valor de la propiedad x.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * Obtiene el valor de la propiedad a.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * Define el valor de la propiedad a.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Obtiene el valor de la propiedad b.
     * 
     */
    public double getB() {
        return b;
    }

    /**
     * Define el valor de la propiedad b.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

    /**
     * Obtiene el valor de la propiedad c.
     * 
     */
    public double getC() {
        return c;
    }

    /**
     * Define el valor de la propiedad c.
     * 
     */
    public void setC(double value) {
        this.c = value;
    }

    /**
     * Obtiene el valor de la propiedad t.
     * 
     */
    public double getT() {
        return t;
    }

    /**
     * Define el valor de la propiedad t.
     * 
     */
    public void setT(double value) {
        this.t = value;
    }

}
