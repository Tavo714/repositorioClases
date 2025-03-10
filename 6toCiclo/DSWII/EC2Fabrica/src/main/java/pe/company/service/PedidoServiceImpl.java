package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Pedido;
import pe.company.repository.PedidoRepository;
import pe.company.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository repository;
 
	@Override
	@Transactional
	public void insert(Pedido pedido) {
		repository.save(pedido);		
	}
 
	@Override
	@Transactional
	public void update(Pedido pedido) {
		repository.save(pedido);		
	}
 
	@Override
	@Transactional
	public void delete(Integer num_pedidogvm) {
		repository.deleteById(num_pedidogvm);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Pedido findById(Integer num_pedidogvm) {
		return repository.findById(num_pedidogvm).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Pedido> findAll() {
		return (Collection<Pedido>)repository.findAll();
	}

}
