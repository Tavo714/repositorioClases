package pe.company.repository;

import java.util.Collection;
import pe.company.model.Proyecto;

public interface ProyectoRepository {
	
	public abstract void insert(Proyecto proyecto);
	public abstract void update(Proyecto proyecto);
	public abstract void delete(Integer codProyecto);
	public abstract Proyecto findById(Integer codProyecto);
	public abstract Collection<Proyecto> findAll();

}
