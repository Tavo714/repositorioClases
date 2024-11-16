
package model;

import java.util.Date;

public class servicio {
    
    private int id;
    private String descripcion;
    private double importe;
    private Date fecha;
    private String beneficio;

    public servicio() {
    }

    public servicio(int id, String descripcion, double importe, Date fecha, String beneficio) {
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
        this.fecha = fecha;
        this.beneficio = beneficio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }
    
    
    
}
