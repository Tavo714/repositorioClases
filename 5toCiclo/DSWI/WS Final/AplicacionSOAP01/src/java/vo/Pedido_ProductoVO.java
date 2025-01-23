package vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pedidoProducto")
public class Pedido_ProductoVO {
    private Integer idpedido;
    private Integer idproducto;
    private Integer cantidad;
    private Double precio_unitario;

    public Pedido_ProductoVO() {}

    public Pedido_ProductoVO(Integer idpedido, Integer idproducto, Integer cantidad, Double precio_unitario) {
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }
    @XmlElement
    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }
    @XmlElement
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }
    @XmlElement
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    @XmlElement
    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
}
