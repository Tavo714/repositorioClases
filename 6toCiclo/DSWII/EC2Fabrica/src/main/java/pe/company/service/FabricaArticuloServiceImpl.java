package pe.company.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.FabricaArticulo;
import pe.company.repository.FabricaArticuloRepository;

@Service
public class FabricaArticuloServiceImpl implements FabricaArticuloService {

    @Autowired
    private FabricaArticuloRepository repository;

    @Override
    @Transactional
    public void insert(FabricaArticulo fabricaArticulo) {
        repository.save(fabricaArticulo);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FabricaArticulo> findByFabricaId(Integer fabricaId) {
        return repository.findByFabricaId(fabricaId);
    }
}
