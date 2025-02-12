package pe.valera.service;

import java.util.Collection;
import pe.valera.model.Proyecto;

public interface ProyectoService {
	
	public abstract void insert(Proyecto proyecto);
	public abstract void update(Proyecto proyecto);
	public abstract void delete(Integer codigoPro);
	public abstract Proyecto findById(Integer codigoPro);
	public abstract Collection<Proyecto> findAll();

}
