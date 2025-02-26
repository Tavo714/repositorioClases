package pe.escuela.service;

import java.util.Collection;
import pe.escuela.model.Instructor;
import pe.escuela.model.Tecnologia;
 
 
public interface InstructorService {
	
	public abstract void insert(Instructor instructor);
	public abstract void update(Instructor instructor);
	public abstract void delete(Integer instructorId);
	public abstract Instructor findById(Integer instructorId);
	public abstract Collection<Instructor> findAll();

}
