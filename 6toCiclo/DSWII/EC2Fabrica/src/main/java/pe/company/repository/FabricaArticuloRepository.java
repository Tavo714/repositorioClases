package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.FabricaArticulo;
import java.util.List;

@Repository
public interface FabricaArticuloRepository extends CrudRepository<FabricaArticulo, Integer> {
    List<FabricaArticulo> findByFabricaId(Integer fabricaId);
}
