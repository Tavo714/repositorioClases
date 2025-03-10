package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Cliente;
import pe.company.repository.ClienteRepository;
import pe.company.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
 
	@Override
	@Transactional
	public void insert(Cliente cliente) {
		repository.save(cliente);		
	}
 
	@Override
	@Transactional
	public void update(Cliente cliente) {
		repository.save(cliente);		
	}
 
	@Override
	@Transactional
	public void delete(Integer num_clientegvm) {
		repository.deleteById(num_clientegvm);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Integer num_clientegvm) {
		return repository.findById(num_clientegvm).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Cliente> findAll() {
		return (Collection<Cliente>)repository.findAll();
	}

}
