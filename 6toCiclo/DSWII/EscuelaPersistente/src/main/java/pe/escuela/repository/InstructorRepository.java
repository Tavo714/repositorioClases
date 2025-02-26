package pe.escuela.repository;

import org.springframework.data.repository.CrudRepository;
import pe.escuela.model.Instructor;
 
 
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
	
}
