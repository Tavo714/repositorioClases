package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Medicamento;
import pe.company.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
	
	@Autowired
	private MedicamentoRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Medicamento> findAll() {
		return (Collection<Medicamento>)repository.findAll();
	}

}
