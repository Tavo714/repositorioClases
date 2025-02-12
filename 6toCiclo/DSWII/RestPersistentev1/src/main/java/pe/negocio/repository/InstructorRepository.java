package pe.negocio.repository;

import org.springframework.data.repository.CrudRepository;
import pe.negocio.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Integer>{
	
}
