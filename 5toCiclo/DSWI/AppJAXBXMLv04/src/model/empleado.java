package model;
 
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
@XmlRootElement
@XmlType(propOrder = {"id_empleado", "nombre", "apellidos", "fecha_contrato"})
public class empleado {
    private Integer id_empleado;
    private String nombre;
    private String apellidos;
    private Date fecha_contrato;
    
    public empleado() {}
 
    public empleado(Integer id_empleado, String nombre, String apellidos, Date fecha_contrato) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_contrato = fecha_contrato;
    }

    @XmlAttribute
    public Integer getId_empleado() {
        return id_empleado;
    }
 
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellidos() {
        return apellidos;
    }
 
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
 
    public Date getFecha_contrato() {
        return fecha_contrato;
    }
 
    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }
}

 