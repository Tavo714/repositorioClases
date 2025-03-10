package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import pe.company.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
