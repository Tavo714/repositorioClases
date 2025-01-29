package pe.company.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.company.model.Proyecto;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository{
	
public static Collection<Proyecto> itemsProyecto = new ArrayList<>();
	
	@Override
	public void insert(Proyecto proyecto) {
		itemsProyecto.add(proyecto);
	}
	
	@Override
	public void update(Proyecto proyecto) {
		Proyecto oldProyecto=findById(proyecto.getCodProyecto());
		itemsProyecto.remove(oldProyecto);
		
		Proyecto newProyecto=new Proyecto(proyecto);
		itemsProyecto.add(newProyecto);
	}
	
	@Override
	public void delete(Integer codProyecto) {
		Proyecto proyecto = findById(codProyecto);
		itemsProyecto.remove(proyecto);
	}
	
	@Override
	public Proyecto findById(Integer codProyecto) {
		Optional<Proyecto> proyecto = 
				itemsProyecto.stream().filter(p->p.getCodProyecto() == codProyecto).findFirst();
		return proyecto.orElse(null);
	}
	
	@Override
	public Collection<Proyecto> findAll(){
		return itemsProyecto;
	}


}
