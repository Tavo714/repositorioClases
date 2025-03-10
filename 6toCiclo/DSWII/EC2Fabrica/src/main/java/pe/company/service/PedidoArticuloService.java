package pe.company.service;

import java.util.List;
import pe.company.model.PedidoArticulo;

public interface PedidoArticuloService {
    void insert(PedidoArticulo pedidoArticulo);
    void delete(Integer id);
    List<PedidoArticulo> findByPedidoId(Integer pedidoId);
}
