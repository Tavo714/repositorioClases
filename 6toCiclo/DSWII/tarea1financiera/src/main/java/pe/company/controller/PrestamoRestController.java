package pe.company.controller;

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
import pe.company.model.Prestamo;
import pe.company.service.PrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamoRestController {
	
	@Autowired
	private PrestamoService prestamoService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Prestamo> itemsPrestamo=prestamoService.findAll();		
		return new ResponseEntity<>(itemsPrestamo,HttpStatus.OK); //Http status code
	}
	
	@GetMapping("/buscar/{nroPrestamo}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer nroPrestamo) {
		Prestamo prestamo=prestamoService.findById(nroPrestamo);		
		if(prestamo!=null) {
			return new ResponseEntity<>(prestamo,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Prestamo prestamo) {
		prestamoService.insert(prestamo);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
 
	@PutMapping("/editar/{nroPrestamo}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer nroPrestamo,
                                        @RequestBody Prestamo newPrestamo) {		
		Prestamo prestamo=prestamoService.findById(nroPrestamo);		
		if(prestamo!=null) {
			prestamo.setFecha(newPrestamo.getFecha());
			prestamo.setFinancista(newPrestamo.getFinancista());
			prestamo.setCliente(newPrestamo.getCliente());
			prestamo.setImporte(newPrestamo.getImporte());
			prestamo.setNroLetras(newPrestamo.getNroLetras());	
			prestamo.setInteres(newPrestamo.getInteres());
			prestamoService.update(prestamo);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
 
	@DeleteMapping("/borrar/{nroPrestamo}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer nroPrestamo)
	{
		Prestamo prestamo=prestamoService.findById(nroPrestamo);
		
		if(prestamo!=null) {
			prestamoService.delete(nroPrestamo);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}


}
