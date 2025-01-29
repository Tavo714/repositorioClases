package pe.company.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.company.model.Prestamo;

@Repository
public class PrestamoRepositoryImpl implements PrestamoRepository{
	
public static Collection<Prestamo> itemsPrestamo = new ArrayList<>();
	
	@Override
	public void insert(Prestamo prestamo) {
		itemsPrestamo.add(prestamo);
	}
	
	@Override
	public void update(Prestamo prestamo) {
		Prestamo oldPrestamo=findById(prestamo.getNroPrestamo());
		itemsPrestamo.remove(oldPrestamo);
		
		Prestamo newPrestamo=new Prestamo(prestamo);
		itemsPrestamo.add(newPrestamo);
	}
	
	@Override
	public void delete(Integer nroPrestamo) {
		Prestamo prestamo = findById(nroPrestamo);
		itemsPrestamo.remove(prestamo);
	}
	
	@Override
	public Prestamo findById(Integer nroPrestamo) {
		Optional<Prestamo> prestamo = 
				itemsPrestamo.stream().filter(p->p.getNroPrestamo() == nroPrestamo).findFirst();
		return prestamo.orElse(null);
	}
	
	@Override
	public Collection<Prestamo> findAll(){
		return itemsPrestamo;
	}


}
