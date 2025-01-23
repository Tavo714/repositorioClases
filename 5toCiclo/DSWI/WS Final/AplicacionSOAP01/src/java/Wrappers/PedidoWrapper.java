package Wrappers;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import vo.PedidoVO;

@XmlRootElement(name = "pedidos")
public class PedidoWrapper {
    private List<PedidoVO> pedidos;

    @XmlElement(name = "pedido")
    public List<PedidoVO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoVO> pedidos) {
        this.pedidos = pedidos;
    }
}
