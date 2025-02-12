package pe.valera.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.valera.model.Amortizacion;
import pe.valera.service.AmortizacionService;

@RestController
@RequestMapping("/amortizacion")
public class AmortizacionRestController {
	
	@Autowired
	private AmortizacionService amortizacionService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Amortizacion> itemsAmortizacion=amortizacionService.findAll();		
		return new ResponseEntity<>(itemsAmortizacion,HttpStatus.OK); //Http status code
	}
	
	@GetMapping("/buscar/{amorNum}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer amorNum) {
		Amortizacion amortizacion=amortizacionService.findById(amorNum);		
		if(amortizacion!=null) {
			return new ResponseEntity<>(amortizacion,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Amortizacion amortizacion) {
		amortizacionService.insert(amortizacion);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
 
	@PutMapping("/editar/{amorNum}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer amorNum,
                                        @RequestBody Amortizacion newAmortizacion) {		
		Amortizacion amortizacion=amortizacionService.findById(amorNum);		
		if(amortizacion!=null) {
			amortizacion.setAmorFecha(newAmortizacion.getAmorFecha());
			amortizacion.setPrestaNum(newAmortizacion.getPrestaNum());
			amortizacion.setPrestaFecha(newAmortizacion.getPrestaFecha());
			amortizacion.setDniCliente(newAmortizacion.getDniCliente());
			amortizacion.setCapitalImp(newAmortizacion.getCapitalImp());	
			amortizacion.setInteresImp(newAmortizacion.getInteresImp());
			amortizacion.setAmorTotal(newAmortizacion.getAmorTotal());
			amortizacionService.update(amortizacion);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
 
	@DeleteMapping("/borrar/{amorNum}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer amorNum)
	{
		Amortizacion amortizacion=amortizacionService.findById(amorNum);
		
		if(amortizacion!=null) {
			amortizacionService.delete(amorNum);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}

