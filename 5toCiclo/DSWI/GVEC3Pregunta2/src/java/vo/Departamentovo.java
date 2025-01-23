package vo;

public class Departamentovo {
    private int id_departamento;
    private String nombre;
    private String edificio;
    private int planta;

    public Departamentovo() {
    }

    public Departamentovo(int id_departamento, String nombre, String edificio, int planta) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.edificio = edificio;
        this.planta = planta;
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

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }
}
