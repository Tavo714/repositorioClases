package pe.escuela.repository;

import org.springframework.data.repository.CrudRepository;
import pe.escuela.model.Taller;
import pe.escuela.model.Instructor;
 
 
public interface TallerRepository extends CrudRepository<Taller,Integer>{
 
}
