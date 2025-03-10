package pe.company.service;

import java.util.List;
import pe.company.model.FabricaArticulo;

public interface FabricaArticuloService {
    void insert(FabricaArticulo fabricaArticulo);
    void delete(Integer id);
    List<FabricaArticulo> findByFabricaId(Integer fabricaId);
}
