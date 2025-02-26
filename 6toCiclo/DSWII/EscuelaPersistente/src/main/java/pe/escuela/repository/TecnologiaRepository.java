package pe.escuela.repository;

import org.springframework.data.repository.CrudRepository;
import pe.escuela.model.Tecnologia;
import pe.escuela.model.Instructor;
 
public interface TecnologiaRepository extends CrudRepository<Tecnologia,Integer>{

}
