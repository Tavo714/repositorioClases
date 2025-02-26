package pe.escuela.service;

import java.util.Collection;

import pe.escuela.model.Tecnologia;
 
public interface TecnologiaService {
 
	public abstract void insert(Tecnologia tecnologia);
	public abstract void update(Tecnologia tecnologia);
	public abstract void delete(Integer tecnologiaId);
	public abstract Tecnologia findById(Integer tecnologiaId);
	public abstract Collection<Tecnologia> findAll();

}
