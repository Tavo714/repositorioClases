package pe.valera.service;

import java.util.Collection;
import pe.valera.model.Amortizacion;

public interface AmortizacionService {
	
	public abstract void insert(Amortizacion amortizacion);
	public abstract void update(Amortizacion amortizacion);
	public abstract void delete(Integer amorNum);
	public abstract Amortizacion findById(Integer amorNum);
	public abstract Collection<Amortizacion> findAll();


}
