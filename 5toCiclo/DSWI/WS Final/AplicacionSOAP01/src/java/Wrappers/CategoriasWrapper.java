package Wrappers;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import vo.CategoriaVO;

@XmlRootElement(name = "categorias")
public class CategoriasWrapper {
    private List<CategoriaVO> categorias;

    @XmlElement(name = "categoria")
    public List<CategoriaVO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaVO> categorias) {
        this.categorias = categorias;
    }
}
