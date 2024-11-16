
package wsalumno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wscalcprom complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wscalcprom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carrera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="turno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="practica" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="participacion" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="examen" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wscalcprom", propOrder = {
    "nombre",
    "carrera",
    "turno",
    "practica",
    "participacion",
    "examen"
})
public class Wscalcprom {

    protected String nombre;
    protected String carrera;
    protected String turno;
    protected double practica;
    protected double participacion;
    protected double examen;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad carrera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Define el valor de la propiedad carrera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrera(String value) {
        this.carrera = value;
    }

    /**
     * Obtiene el valor de la propiedad turno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Define el valor de la propiedad turno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTurno(String value) {
        this.turno = value;
    }

    /**
     * Obtiene el valor de la propiedad practica.
     * 
     */
    public double getPractica() {
        return practica;
    }

    /**
     * Define el valor de la propiedad practica.
     * 
     */
    public void setPractica(double value) {
        this.practica = value;
    }

    /**
     * Obtiene el valor de la propiedad participacion.
     * 
     */
    public double getParticipacion() {
        return participacion;
    }

    /**
     * Define el valor de la propiedad participacion.
     * 
     */
    public void setParticipacion(double value) {
        this.participacion = value;
    }

    /**
     * Obtiene el valor de la propiedad examen.
     * 
     */
    public double getExamen() {
        return examen;
    }

    /**
     * Define el valor de la propiedad examen.
     * 
     */
    public void setExamen(double value) {
        this.examen = value;
    }

}
