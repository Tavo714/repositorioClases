package pe.escuela.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.escuela.model.Taller;
import pe.escuela.model.Instructor;
import pe.escuela.repository.TallerRepository;
import pe.escuela.repository.TallerRepository;
import pe.escuela.repository.InstructorRepository;
 
@Service
public class TallerServiceImpl implements TallerService{
	
	@Autowired
	private TallerRepository repository;
 
	@Override
	@Transactional
	public void insert(Taller taller) {
		repository.save(taller);		
	}
 
	@Override
	@Transactional
	public void update(Taller taller) {
		repository.save(taller);		
	}
 
	@Override
	@Transactional
	public void delete(Integer tallerId) {
		repository.deleteById(tallerId);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Taller findById(Integer tallerId) {
		return repository.findById(tallerId).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Taller> findAll() {
		return (Collection<Taller>)repository.findAll();
	}
 
}
