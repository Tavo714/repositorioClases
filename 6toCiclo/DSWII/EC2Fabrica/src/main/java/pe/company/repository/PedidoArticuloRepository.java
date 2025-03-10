package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.PedidoArticulo;
import java.util.List;

@Repository
public interface PedidoArticuloRepository extends CrudRepository<PedidoArticulo, Integer> {
    List<PedidoArticulo> findByPedidoId(Integer pedidoId);
}
