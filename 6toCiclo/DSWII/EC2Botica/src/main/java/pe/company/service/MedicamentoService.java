package pe.company.service;

import java.util.Collection;
import org.springframework.stereotype.Service;
import pe.company.model.Medicamento;

public interface MedicamentoService {
	
	public abstract Collection<Medicamento> findAll();

}
