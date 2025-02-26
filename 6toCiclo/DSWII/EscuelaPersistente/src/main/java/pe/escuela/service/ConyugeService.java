package pe.escuela.service;

import java.util.Collection;
import pe.escuela.model.Conyuge;
 
public interface ConyugeService {
 
	public abstract void insert(Conyuge conyuge);
	public abstract void update(Conyuge conyuge);
	public abstract void delete(Integer conyugeId);
	public abstract Conyuge findById(Integer conyugeId);
	public abstract Collection<Conyuge> findAll();
 
}
