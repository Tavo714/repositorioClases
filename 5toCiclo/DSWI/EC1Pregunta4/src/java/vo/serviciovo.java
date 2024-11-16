
package vo;

import java.util.ArrayList;
import java.util.Collection;

public class serviciovo {
    
    private int codigo;
    private String descripcion;
    private double importe;
    private Collection<mascotavo> itemsMascota=new ArrayList();

    public serviciovo() {
    }

    public serviciovo(int codigo, String descripcion, double importe) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Collection<mascotavo> getItemsMascota() {
        return itemsMascota;
    }

    public void setItemsMascota(Collection<mascotavo> itemsMascota) {
        this.itemsMascota = itemsMascota;
    }
    
    
    
}
