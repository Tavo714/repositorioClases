package vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "categoria")
public class CategoriaVO {
    private Integer idcategoria;
    private String descat;
    
    public CategoriaVO(){}
    public CategoriaVO(Integer idcategoria, String descat){
        this.idcategoria = idcategoria;
        this.descat = descat;
    }
    
    @XmlElement
    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }
    
    @XmlElement
    public String getDescat() {
        return descat;
    }

    public void setDescat(String descat) {
        this.descat = descat;
    }
    

}
