package pe.company.service;

import java.util.Collection;
import pe.company.model.Fabrica;

public interface FabricaService {
	
	public abstract void insert(Fabrica fabrica);
	public abstract void update(Fabrica fabrica);
	public abstract void delete(Integer num_fabricagvm);
	public abstract Fabrica findById(Integer num_fabricagvm);
	public abstract Collection<Fabrica> findAll();


}
