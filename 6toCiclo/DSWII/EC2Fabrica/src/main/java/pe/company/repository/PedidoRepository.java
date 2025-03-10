package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import pe.company.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

}
