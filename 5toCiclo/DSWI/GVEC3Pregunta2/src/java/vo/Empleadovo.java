package vo;

public class Empleadovo {
    private int id_empleado;
    private int id_departamento;
    private String nombre;
    private String puesto;
    private String fecha_alta;
    private double sueldo;
    private Departamentovo departamento;

    public Empleadovo() {
    }

    public Empleadovo(int id_empleado, int id_departamento, String nombre, String puesto, String fecha_alta, double sueldo, Departamentovo departamento) {
        this.id_empleado = id_empleado;
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.puesto = puesto;
        this.fecha_alta = fecha_alta;
        this.sueldo = sueldo;
        this.departamento = departamento;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Departamentovo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentovo departamento) {
        this.departamento = departamento;
    }
}
