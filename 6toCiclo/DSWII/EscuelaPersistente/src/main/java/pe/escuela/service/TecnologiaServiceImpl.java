package pe.escuela.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.escuela.model.Tecnologia;
import pe.escuela.model.Instructor;
import pe.escuela.repository.TecnologiaRepository;
import pe.escuela.repository.InstructorRepository;
 
@Service
public class TecnologiaServiceImpl implements TecnologiaService {
	
	@Autowired
	private TecnologiaRepository repository;
 
	@Override
	@Transactional
	public void insert(Tecnologia tecnologia) {
		repository.save(tecnologia);		
	}
 
	@Override
	@Transactional
	public void update(Tecnologia tecnologia) {
		repository.save(tecnologia);		
	}
 
	@Override
	@Transactional
	public void delete(Integer tecnologiaId) {
		repository.deleteById(tecnologiaId);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Tecnologia findById(Integer tecnologiaId) {
		return repository.findById(tecnologiaId).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Tecnologia> findAll() {
		return (Collection<Tecnologia>)repository.findAll();
	}

}
