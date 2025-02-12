package pe.negocio.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.negocio.model.Instructor;
import pe.negocio.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorRepository repository;
 
	@Override
	@Transactional
	public void insert(Instructor instructor) {
		repository.save(instructor);		
	}
 
	@Override
	@Transactional
	public void update(Instructor instructor) {
		repository.save(instructor);		
	}
 
	@Override
	@Transactional
	public void delete(Integer instructorId) {
		repository.deleteById(instructorId);		
	}
 
	@Override
	@Transactional(readOnly=true)
	public Instructor findById(Integer instructorId) {
		return repository.findById(instructorId).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Collection<Instructor> findAll() {
		return (Collection<Instructor>)repository.findAll();
	}

}
