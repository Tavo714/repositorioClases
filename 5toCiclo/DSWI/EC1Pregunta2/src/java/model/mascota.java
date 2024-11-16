
package model;

import java.util.Date;


public class mascota {
    
    private Integer id_mascota;
    private String nombre;
    private String animal;
    private Date nacimiento;
    private Date registro;
    private String dni;
    private String dueño;
    private String domicilio;

    public mascota() {
    }

    public mascota(Integer id_mascota, String nombre, String animal, Date nacimiento, Date registro, String dni, String dueño, String domicilio) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.animal = animal;
        this.nacimiento = nacimiento;
        this.registro = registro;
        this.dni = dni;
        this.dueño = dueño;
        this.domicilio = domicilio;
    }

    public Integer getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
