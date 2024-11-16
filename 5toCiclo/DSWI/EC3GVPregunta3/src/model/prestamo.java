
package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"nroprestamo", "fechaprestamo", "nombre", "importe","interes","nrocuotas"})
public class prestamo {
    private int nroprestamo;
    private Date fechaprestamo;
    private String nombre;
    private double importe;
    private double interes;
    private int nrocuotas;

    public prestamo() {
    }

    public prestamo(int nroprestamo, Date fechaprestamo, String nombre, double importe, double interes, int nrocuotas) {
        this.nroprestamo = nroprestamo;
        this.fechaprestamo = fechaprestamo;
        this.nombre = nombre;
        this.importe = importe;
        this.interes = interes;
        this.nrocuotas = nrocuotas;
    }
    @XmlAttribute
    public int getNroprestamo() {
        return nroprestamo;
    }

    public void setNroprestamo(int nroprestamo) {
        this.nroprestamo = nroprestamo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getNrocuotas() {
        return nrocuotas;
    }

    public void setNrocuotas(int nrocuotas) {
        this.nrocuotas = nrocuotas;
    }

}
