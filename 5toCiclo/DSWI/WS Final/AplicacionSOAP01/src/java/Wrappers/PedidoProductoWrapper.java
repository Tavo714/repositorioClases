package Wrappers;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import vo.Pedido_ProductoVO;

@XmlRootElement(name = "pedidosProductos")
public class PedidoProductoWrapper {
    private List<Pedido_ProductoVO> pedidosProductos;

    @XmlElement(name = "pedidoProducto")
    public List<Pedido_ProductoVO> getPedidosProductos() {
        return pedidosProductos;
    }

    public void setPedidosProductos(List<Pedido_ProductoVO> pedidosProductos) {
        this.pedidosProductos = pedidosProductos;
    }
}
