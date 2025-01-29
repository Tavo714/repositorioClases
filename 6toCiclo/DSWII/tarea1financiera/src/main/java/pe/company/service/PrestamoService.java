package pe.company.service;

import java.util.Collection;
import pe.company.model.Prestamo;

public interface PrestamoService {
	
	public abstract void insert(Prestamo prestamo);
	public abstract void update(Prestamo prestamo);
	public abstract void delete(Integer nroPrestamo);
	public abstract Prestamo findById(Integer nroPrestamo);
	public abstract Collection<Prestamo> findAll();


}
