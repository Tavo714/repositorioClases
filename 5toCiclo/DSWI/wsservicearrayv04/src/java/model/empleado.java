/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class empleado {
    
    private Integer id_empleado;
    private String nombre;
    private Date fecha_contrato;
    private String profesion;
    private Double sueldo;
    
    //hacer publica la clase
    public empleado(){ 
        
    }
    
    //Insertar codigo constructor
    public empleado(Integer id_empleado, String nombre, Date fecha_contrato, String profesion, Double sueldo) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.fecha_contrato = fecha_contrato;
        this.profesion = profesion;
        this.sueldo = sueldo;
    }
    
    //Insertar getter y setters

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

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
        
}
