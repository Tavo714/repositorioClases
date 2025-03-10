package pe.company.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.PedidoArticulo;
import pe.company.repository.PedidoArticuloRepository;

@Service
public class PedidoArticuloServiceImpl implements PedidoArticuloService {

    @Autowired
    private PedidoArticuloRepository repository;

    @Override
    @Transactional
    public void insert(PedidoArticulo pedidoArticulo) {
        repository.save(pedidoArticulo);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoArticulo> findByPedidoId(Integer pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }
}
