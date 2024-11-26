package vo;
 
import java.util.ArrayList;
import java.util.Collection;
 
public class categoriavo {
    private int id_categoria;
    private String descripcion;
    private Collection<productovo> itemsproducto = new ArrayList();
    public categoriavo() {
    }
 
    public categoriavo(int id_categoria, String descripcion) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
    }
 
    public int getId_categoria() {
        return id_categoria;
    }
 
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
 
    public String getDescripcion() {
        return descripcion;
    }
 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    public Collection<productovo> getItemsproducto() {
        return itemsproducto;
    }
 
    public void setItemsproducto(Collection<productovo> itemsproducto) {
        this.itemsproducto = itemsproducto;
    }

}
