package pe.company.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.company.model.Prestamo;
import pe.company.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService{
	
	@Autowired
	private PrestamoRepository repository;
	
	@Override
	public void insert(Prestamo prestamo) {
		repository.insert(prestamo);
	}
	
	@Override
	public void update(Prestamo prestamo) {
		repository.update(prestamo);
	}
	
	@Override
	public void delete(Integer nroPrestamo) {
		repository.delete(nroPrestamo);
	}
	
	@Override
	public Prestamo findById(Integer nroPrestamo) {
		return repository.findById(nroPrestamo);
	}
	
	@Override
	public Collection<Prestamo> findAll(){
		return repository.findAll();
	}


}
