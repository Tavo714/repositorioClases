package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Articulo;
import pe.company.repository.ArticuloRepository;
import pe.company.service.ArticuloService;

@Service
public class ArticuloServiceImpl implements ArticuloService{
	
	@Autowired
	private ArticuloRepository repository;
 
	@Override
	@Transactional
	public void insert(Articulo articulo) {
		repository.save(articulo);		
	}
 
	@Override
	@Transactional
	public void update(Articulo articulo) {
		repository.save(articulo);		
	}
 
	@Override
	@Transactional
	public void delete(Integer num_articulogvm) {
		repository.deleteById(num_articulogvm);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Articulo findById(Integer num_articulogvm) {
		return repository.findById(num_articulogvm).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Articulo> findAll() {
		return (Collection<Articulo>)repository.findAll();
	}

}
