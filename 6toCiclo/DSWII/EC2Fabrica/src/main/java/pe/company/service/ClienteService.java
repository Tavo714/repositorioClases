package pe.company.service;

import java.util.Collection;
import pe.company.model.Cliente;

public interface ClienteService {
	
	public abstract void insert(Cliente cliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer num_clientegvm);
	public abstract Cliente findById(Integer num_clientegvm);
	public abstract Collection<Cliente> findAll();

}
