
package vo;

import java.util.ArrayList;
import java.util.Collection;

public class areavo {
    
    private int id_area;
    private String nombre;
    private Collection<medicovo> itemsMedico=new ArrayList();

    public areavo() {
    }

    public areavo(int id_area, String nombre) {
        this.id_area = id_area;
        this.nombre = nombre;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<medicovo> getItemsMedico() {
        return itemsMedico;
    }

    public void setItemsMedico(Collection<medicovo> itemsMedico) {
        this.itemsMedico = itemsMedico;
    }
    
    
    
}