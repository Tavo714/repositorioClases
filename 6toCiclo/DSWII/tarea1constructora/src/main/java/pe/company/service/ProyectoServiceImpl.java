package pe.company.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.company.model.Proyecto;
import pe.company.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoRepository repository;
	
	@Override
	public void insert(Proyecto proyecto) {
		repository.insert(proyecto);
	}
	
	@Override
	public void update(Proyecto proyecto) {
		repository.update(proyecto);
	}
	
	@Override
	public void delete(Integer codProyecto) {
		repository.delete(codProyecto);
	}
	
	@Override
	public Proyecto findById(Integer codProyecto) {
		return repository.findById(codProyecto);
	}
	
	@Override
	public Collection<Proyecto> findAll(){
		return repository.findAll();
	}


}
