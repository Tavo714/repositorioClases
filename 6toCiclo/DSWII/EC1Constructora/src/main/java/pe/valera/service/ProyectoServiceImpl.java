package pe.valera.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.valera.model.Proyecto;
import pe.valera.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoRepository repository;
 
	@Override
	@Transactional
	public void insert(Proyecto proyecto) {
		repository.save(proyecto);		
	}
 
	@Override
	@Transactional
	public void update(Proyecto proyecto) {
		repository.save(proyecto);		
	}
 
	@Override
	@Transactional
	public void delete(Integer codigoPro) {
		repository.deleteById(codigoPro);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Proyecto findById(Integer codigoPro) {
		return repository.findById(codigoPro).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Proyecto> findAll() {
		return (Collection<Proyecto>)repository.findAll();
	}


}
