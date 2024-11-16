
package model;

import java.util.Collection;

public class area {
    
    private Integer id_area;
    private String nombre;
    private Integer telefono;
    private Collection<String> empleados;

    public area() {
    }

    public area(Integer id_area, String nombre, Integer telefono, Collection<String> empleados) {
        this.id_area = id_area;
        this.nombre = nombre;
        this.telefono = telefono;
        this.empleados = empleados;
    }

    public Integer getId_area() {
        return id_area;
    }

    public void setId_area(Integer id_area) {
        this.id_area = id_area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Collection<String> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Collection<String> empleados) {
        this.empleados = empleados;
    }   
}
