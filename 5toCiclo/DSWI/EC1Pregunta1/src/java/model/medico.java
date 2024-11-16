
package model;

import java.util.Date;


public class medico {
    
    private Integer id_medico;
    private String dni;
    private String apellidos;
    private String nombres;
    private String titulo;
    private String especialidad;
    private Date nacimiento;
    private Date ingreso;
    private Double basico;

    public medico() {
    }

    public medico(Integer id_medico, String dni, String apellidos, String nombres, String titulo, String especialidad, Date nacimiento, Date ingreso, Double basico) {
        this.id_medico = id_medico;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.titulo = titulo;
        this.especialidad = especialidad;
        this.nacimiento = nacimiento;
        this.ingreso = ingreso;
        this.basico = basico;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Double getBasico() {
        return basico;
    }

    public void setBasico(Double basico) {
        this.basico = basico;
    }
    
}
