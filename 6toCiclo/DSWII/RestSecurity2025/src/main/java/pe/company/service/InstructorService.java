package pe.company.service;

import java.util.Collection;
import pe.company.model.Instructor;
 
public interface InstructorService {
	
	public abstract Collection<Instructor> findAll();

}
