package pe.company.repository;

import java.util.Collection;
import pe.company.model.Prestamo;

public interface PrestamoRepository {
	
	public abstract void insert(Prestamo prestamo);
	public abstract void update(Prestamo prestamo);
	public abstract void delete(Integer nroPrestamo);
	public abstract Prestamo findById(Integer nroPrestamo);
	public abstract Collection<Prestamo> findAll();


}
