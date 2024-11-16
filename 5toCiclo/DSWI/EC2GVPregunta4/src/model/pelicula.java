
package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;

@XmlRootElement
@XmlType(propOrder = {"codigo", "generos", "nombre", "actor", "actriz", "argumento"})
public class pelicula {
    
    private int codigo;
    private Collection<String> generos;
    private String nombre;
    private String actor;
    private String actriz;
    private String argumento;

    public pelicula() {
    }

    public pelicula(int codigo, Collection<String> generos, String nombre, String actor, String actriz, String argumento) {
        this.codigo = codigo;
        this.generos = generos;
        this.nombre = nombre;
        this.actor = actor;
        this.actriz = actriz;
        this.argumento = argumento;
    }
    @XmlAttribute
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Collection<String> getGeneros() {
        return generos;
    }

    public void setGeneros(Collection<String> generos) {
        this.generos = generos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActriz() {
        return actriz;
    }

    public void setActriz(String actriz) {
        this.actriz = actriz;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }



}
