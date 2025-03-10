package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Instructor;
import pe.company.repository.InstructorRepository;
 
@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Instructor> findAll() {
		return (Collection<Instructor>)repository.findAll();
	}
 
}
