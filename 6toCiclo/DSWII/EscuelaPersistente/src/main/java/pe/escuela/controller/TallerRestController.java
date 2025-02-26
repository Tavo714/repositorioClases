package pe.escuela.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
 
import pe.escuela.model.Taller;
import pe.escuela.service.TallerService;
 
@RestController
@RequestMapping("/taller")
public class TallerRestController {
	
	@Autowired
	private TallerService tallerService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Taller> itemsTaller=tallerService.findAll();
		return new ResponseEntity<>(itemsTaller,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Taller taller) {
		tallerService.insert(taller);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
 
}
