package pe.valera.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.valera.model.Amortizacion;
import pe.valera.repository.AmortizacionRepository;

@Service
public class AmortizacionServiceImpl implements AmortizacionService{
	
	@Autowired
	private AmortizacionRepository repository;
	
	@Override
	public void insert(Amortizacion amortizacion) {
		repository.insert(amortizacion);
	}
	
	@Override
	public void update(Amortizacion amortizacion) {
		repository.update(amortizacion);
	}
	
	@Override
	public void delete(Integer amorNum) {
		repository.delete(amorNum);
	}
	
	@Override
	public Amortizacion findById(Integer amorNum) {
		return repository.findById(amorNum);
	}
	
	@Override
	public Collection<Amortizacion> findAll(){
		return repository.findAll();
	}


}
