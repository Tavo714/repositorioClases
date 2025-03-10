package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import pe.company.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

}
