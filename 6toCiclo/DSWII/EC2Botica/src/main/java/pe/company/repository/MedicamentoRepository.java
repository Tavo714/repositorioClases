package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.company.model.Medicamento;

@Repository
public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer>{

}
