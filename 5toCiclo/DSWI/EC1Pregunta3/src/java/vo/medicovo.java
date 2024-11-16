
package vo;

import java.util.Date;

public class medicovo {
    
    private int dni;
    private String apellidos;
    private String nombres;
    private String titulo;
    private String especialidad;
    private Date nacimiento;
    private Date ingreso;
    private double basico;
    private double bonificaciones;
    private double descuentos;
    private areavo area;

    public medicovo() {
    }

    public medicovo(int dni, String apellidos, String nombres, String titulo, String especialidad, Date nacimiento, Date ingreso, double basico, double bonificaciones, double descuentos, areavo area) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.titulo = titulo;
        this.especialidad = especialidad;
        this.nacimiento = nacimiento;
        this.ingreso = ingreso;
        this.basico = basico;
        this.bonificaciones = bonificaciones;
        this.descuentos = descuentos;
        this.area = area;
    }
    
    @Override
    public String toString(){
        return "MedicoVo{" + 
                "dni=" + dni + 
                ", apellidos=" + apellidos + 
                ", nombres=" + nombres + 
                ", titulo=" + titulo + 
                ", especialidad=" + especialidad + 
                ", nacimiento=" + nacimiento + 
                ", ingreso=" + ingreso + 
                ", basico=" + basico + 
                ", bonificaciones=" + bonificaciones + 
                ", descuentos=" + descuentos + 
                ", area=" + area.getNombre() + '}';
        
    

    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public double getBasico() {
        return basico;
    }

    public void setBasico(double basico) {
        this.basico = basico;
    }

    public double getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(double bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public areavo getArea() {
        return area;
    }

    public void setArea(areavo area) {
        this.area = area;
    }
    }
   
