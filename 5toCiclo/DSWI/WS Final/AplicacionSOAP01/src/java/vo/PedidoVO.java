package vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pedido")
public class PedidoVO {
    private Integer idpedido;
    private String fecha;
    private Integer idempleado;
    private Integer idproveedor;
    private String estado;
    private Double total;

    public PedidoVO() {}

    public PedidoVO(Integer idpedido, String fecha, Integer idempleado, Integer idproveedor, String estado, Double total) {
        this.idpedido = idpedido;
        this.fecha = fecha;
        this.idempleado = idempleado;
        this.idproveedor = idproveedor;
        this.estado = estado;
        this.total = total;
    }
    @XmlElement
    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }
    @XmlElement
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @XmlElement
    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }
    @XmlElement
    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }
    @XmlElement
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @XmlElement
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
