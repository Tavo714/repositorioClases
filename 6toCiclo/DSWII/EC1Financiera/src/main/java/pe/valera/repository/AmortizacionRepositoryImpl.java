package pe.valera.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.valera.model.Amortizacion;

@Repository
public class AmortizacionRepositoryImpl implements AmortizacionRepository{
	
public static Collection<Amortizacion> itemsAmortizacion = new ArrayList<>();
	
	@Override
	public void insert(Amortizacion amortizacion) {
		itemsAmortizacion.add(amortizacion);
	}
	
	@Override
	public void update(Amortizacion amortizacion) {
		Amortizacion oldAmortizacion=findById(amortizacion.getAmorNum());
		itemsAmortizacion.remove(oldAmortizacion);
		
		Amortizacion newAmortizacion=new Amortizacion(amortizacion);
		itemsAmortizacion.add(newAmortizacion);
	}
	
	@Override
	public void delete(Integer amorNum) {
		Amortizacion amortizacion = findById(amorNum);
		itemsAmortizacion.remove(amortizacion);
	}
	
	@Override
	public Amortizacion findById(Integer amorNum) {
		Optional<Amortizacion> amortizacion = 
				itemsAmortizacion.stream().filter(p->p.getAmorNum() == amorNum).findFirst();
		return amortizacion.orElse(null);
	}
	
	@Override
	public Collection<Amortizacion> findAll(){
		return itemsAmortizacion;
	}


}
