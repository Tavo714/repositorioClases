
package model;

import java.util.Collection;
import java.util.Date;

public class prestamista {
    
    private String dni;
    private String nombre;
    private Date ingreso;
    private String cargo;
    private String titulo;
    private double sueldo;

    public prestamista() {
    }

    public prestamista(String dni, String nombre, Date ingreso, String cargo, String titulo, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.ingreso = ingreso;
        this.cargo = cargo;
        this.titulo = titulo;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}
