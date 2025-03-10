package pe.company.service;

import java.util.Collection;
import pe.company.model.Pedido;

public interface PedidoService {
	
	public abstract void insert(Pedido pedido);
	public abstract void update(Pedido pedido);
	public abstract void delete(Integer num_pedidogvm);
	public abstract Pedido findById(Integer num_pedidogvm);
	public abstract Collection<Pedido> findAll();

}
