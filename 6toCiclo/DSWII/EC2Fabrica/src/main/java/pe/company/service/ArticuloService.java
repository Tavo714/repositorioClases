package pe.company.service;

import java.util.Collection;
import pe.company.model.Articulo;


public interface ArticuloService {
	
	public abstract void insert(Articulo articulo);
	public abstract void update(Articulo articulo);
	public abstract void delete(Integer num_articulogvm);
	public abstract Articulo findById(Integer num_articulogvm);
	public abstract Collection<Articulo> findAll();

}
