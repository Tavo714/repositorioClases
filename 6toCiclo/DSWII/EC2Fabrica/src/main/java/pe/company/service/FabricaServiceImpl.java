package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Fabrica;
import pe.company.repository.FabricaRepository;
import pe.company.service.FabricaService;

@Service
public class FabricaServiceImpl implements FabricaService{
	
	@Autowired
	private FabricaRepository repository;
 
	@Override
	@Transactional
	public void insert(Fabrica fabrica) {
		repository.save(fabrica);		
	}
 
	@Override
	@Transactional
	public void update(Fabrica fabrica) {
		repository.save(fabrica);		
	}
 
	@Override
	@Transactional
	public void delete(Integer num_fabricagvm) {
		repository.deleteById(num_fabricagvm);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Fabrica findById(Integer num_fabricagvm) {
		return repository.findById(num_fabricagvm).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Fabrica> findAll() {
		return (Collection<Fabrica>)repository.findAll();
	}

}
