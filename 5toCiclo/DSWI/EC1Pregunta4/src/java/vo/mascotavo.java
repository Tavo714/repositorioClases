
package vo;

import java.util.Date;

public class mascotavo {
    
    private int id_mascota;
    private String nombre;
    private String tipo;
    private Date nacimiento;
    private Date registro;
    private String dni_propietario;
    private String propietario;
    private String domicilio;
    private serviciovo servicio;

    public mascotavo() {
    }

    public mascotavo(int id_mascota, String nombre, String tipo, Date nacimiento, Date registro, String dni_propietario, String propietario, String domicilio, serviciovo servicio) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nacimiento = nacimiento;
        this.registro = registro;
        this.dni_propietario = dni_propietario;
        this.propietario = propietario;
        this.domicilio = domicilio;
        this.servicio = servicio;
    }
    
    //OJO CON ESTA ETIQUETA OVERRIDE!!!
    @Override
     public String toString() {

        return  "MascotaVo{" + "id_mascota=" + id_mascota + 
                ", nombre=" + nombre + 
                ", tipo=" + tipo + 
                ", nacimiento=" + nacimiento + 
                ", registro=" + registro + 
                ", dni_propietario=" + dni_propietario + 
                ", propietario=" + propietario + 
                ", domicilio=" + domicilio + 
                ", servicio=" + servicio.getDescripcion() + '}';

    }
//

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public serviciovo getServicio() {
        return servicio;
    }

    public void setServicio(serviciovo servicio) {
        this.servicio = servicio;
    }
     
     
    
}
